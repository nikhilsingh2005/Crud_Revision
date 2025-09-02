package com.nikhil.crud_revision.controllers;

import com.nikhil.crud_revision.entities.Student;
import com.nikhil.crud_revision.services.StudentServiceInterf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentServiceInterf studentService;

    StudentController(StudentServiceInterf studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> listOfStudents = studentService.getAllStudents();
        return new ResponseEntity<>(listOfStudents, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student deletedStudent = studentService.deleteStudentById(id);
        return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/deleteAll")
    public ResponseEntity<Void> deleteStudent() {
        studentService.deleteAllStudents();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
