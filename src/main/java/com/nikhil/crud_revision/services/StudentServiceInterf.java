package com.nikhil.crud_revision.services;


import com.nikhil.crud_revision.entities.Student;

import java.util.List;

public interface StudentServiceInterf {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    Student deleteStudentById(Long id);

    void deleteAllStudents();
}
