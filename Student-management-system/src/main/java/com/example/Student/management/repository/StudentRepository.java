package com.example.Student.management.repository;

import java.util.UUID;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.management.model.Student;

public interface StudentRepository extends JpaRepository<Student, UUID>{
    
}
