package com.example.Student.management.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.management.model.AcademicUnit;

public interface AcademiUnitRepository extends JpaRepository<AcademicUnit, UUID>{
    
}
