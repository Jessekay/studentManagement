package com.example.Student.management.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Student.management.model.AcademicUnit;
import com.example.Student.management.model.EAcademicUnitType;

public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, UUID>{
    Boolean existsByCode(String code);

    Optional<AcademicUnit> findByCode(String code); 

        List<AcademicUnit> findByType(EAcademicUnitType type);

}
