package com.example.Student.management.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.management.model.AcademicUnit;
import com.example.Student.management.service.AcademicUnitService;

@RestController
@RequestMapping(value = "/api/academicUnit")
@CrossOrigin(origins = "http://localhost:3000")
public class AcademicUnitController {

    @Autowired
    private AcademicUnitService academicUnitService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAcademicUnit(@RequestBody AcademicUnit academicUnit) {

        String response = academicUnitService.saveParent(academicUnit);

        if(response.equals("saved successfully")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    @PostMapping(value = "/saveChildOrParent", consumes = MediaType.APPLICATION_JSON_VALUE,
     produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveProgramOrFacultyOrDepartment(@RequestParam(required = false) String parentCode, @RequestBody AcademicUnit academicUnit) {
        String response = academicUnitService.saveProgrammOrFacultyOrDepartemnt(parentCode, academicUnit);

        if (response.equals("Child os saved!")) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else if(response.equals("Child with this code exists")) {
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else if(response.equals("The parent with this code does not exist")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else if(response.equals("Parent is saved!")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }
    }

    @GetMapping(value = "/findByCode")
    public ResponseEntity<?> findProgramByDepartmentCode(@RequestParam String code) {
        Optional<AcademicUnit> parent = academicUnitService.getProgramByDepartmentCode(code);

        if(parent.isPresent()) {
            return new ResponseEntity<>(parent.get().getParent().getParent(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>("Parent not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
