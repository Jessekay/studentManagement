package com.example.Student.management.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.example.Student.management.controller.List;
import com.example.Student.management.model.AcademicUnit;
import com.example.Student.management.model.EAcademicUnitType;
import com.example.Student.management.model.EAcademicUnitType;
import com.example.Student.management.repository.AcademicUnitRepository;

@Service
public class AcademicUnitService {
    @Autowired
    private AcademicUnitRepository academicUnitRepository;

    public String saveParent(AcademicUnit academicUnit) {
        if (!academicUnitRepository.existsByCode(academicUnit.getCode())) {
            academicUnitRepository.save(academicUnit);
            return "Saved successfully";
        } else {
            return "The Unit exists";
        }
    }

    public String saveProgrammOrFacultyOrDepartemnt(String parentCode, AcademicUnit academicUnit) {
        if (parentCode != null) {
            Optional<AcademicUnit> getParent = academicUnitRepository.findByCode(parentCode);

            if (getParent.isPresent()) {
                // bind parent to child
                academicUnit.setParent(getParent.get());

                if(!academicUnitRepository.existsByCode(academicUnit.getCode())) {
                    academicUnitRepository.save(academicUnit);
                    return "Child saved!";
                } else {
                    return "Child with this code exists";
                }
            } else {

                return "The parent with this code does not exist";
            } 
        } else {
            if(!academicUnitRepository.existsByCode(academicUnit.getCode())) {
                academicUnitRepository.save(academicUnit);
                return "Child is saved!";
            } else {
                return "Child already exists";
            }
        }
    }

    public Optional<AcademicUnit> getProgramByDepartmentCode(String code) {
        return academicUnitRepository.findByCode(code);
    }

    public List<AcademicUnit> findByType(String type){
        return academicUnitRepository.findByType(EAcademicUnitType.valueOf(type));
    }
}
