package com.nikhil.crud_revision.services;

import com.nikhil.crud_revision.entities.Student;
import com.nikhil.crud_revision.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceInterf {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student existingStudent = getStudentById(student.getId());
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with id: " + student.getId());
        }

        // Update only non-null fields (to support partial updates)
        if (student.getName() != null) {
            existingStudent.setName(student.getName());
        }
        if (student.getAge() != null) {
            existingStudent.setAge(student.getAge());
        }
        if (student.getRoll_number() != null) {
            existingStudent.setRoll_number(student.getRoll_number());
        }
        if (student.getDepartment() != null) {
            existingStudent.setDepartment(student.getDepartment());
        }
        if (student.getSex() != null) {
            existingStudent.setSex(student.getSex());
        }
        if (student.getCollege_name() != null) {
            existingStudent.setCollege_name(student.getCollege_name());
        }

        return studentRepository.save(existingStudent);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student existingStudent = getStudentById(id);
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.delete(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteAllStudents() {
        List<Student> students = getAllStudents();
        if (students.isEmpty()) {
            throw new RuntimeException("No students found");
        }
        studentRepository.deleteAll();
    }


}
