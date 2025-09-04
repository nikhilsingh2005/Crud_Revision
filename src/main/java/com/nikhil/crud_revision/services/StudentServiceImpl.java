package com.nikhil.crud_revision.services;

import com.nikhil.crud_revision.entities.Student;
import com.nikhil.crud_revision.exceptions.DuplicateEmailException;
import com.nikhil.crud_revision.exceptions.NoStudentsFoundException;
import com.nikhil.crud_revision.exceptions.StudentNotFoundException;
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
        List<Student> listOfStudents = studentRepository.findAll();
        if (listOfStudents.isEmpty()) {
            throw new NoStudentsFoundException();
        }
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            throw new StudentNotFoundException(id);
        }
        return existingStudent;
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new DuplicateEmailException(student.getEmail());
        }
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {

        Student existingStudent = getStudentById(student.getId());

        student.setId(existingStudent.getId());


        return studentRepository.save(existingStudent);
    }

    @Override
    @Transactional
    public Student deleteStudentById(Long id) {
        Student existingStudent = getStudentById(id);

        if (existingStudent == null) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.delete(existingStudent);
        return existingStudent;
    }

    @Override
    @Transactional
    public void deleteAllStudents() {
        List<Student> students = getAllStudents();
        if (students.isEmpty()) {
            throw new NoStudentsFoundException();
        }
        studentRepository.deleteAll();
    }


}
