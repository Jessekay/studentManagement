package com.example.Student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.management.model.Student;
import com.example.Student.management.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        String registration = studentService.saveStudent(student);

        if(registration.equals("Student exists")) {
            return new ResponseEntity<>(registration, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(registration, HttpStatus.CREATED);
        }
    }
}
