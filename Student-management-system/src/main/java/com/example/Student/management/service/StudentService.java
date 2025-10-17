package com.example.Student.management.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Student.management.model.Student;
import com.example.Student.management.repository.StudentRepository;


public class StudentService {

    @Autowired
private StudentRepository studentRepo;


    public String saveStudent(Student student) {
        if(studentRepo.existsByRegNumber(student.getRegNumber())){
            return "Student exists!";
        } else {
            studentRepo.save(student);
            return "Student saved!";
        }
    }
}
