package com.example.Student.management.model;

import java.util.UUID;

public class AcademicUnit {
    private UUID Id;
    private String code;
    private String name;
    private EAcademicUnitType type;
    private AcademicUnit parent;
    public UUID getId() {
        return Id;
    }
    public void setId(UUID id) {
        Id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public EAcademicUnitType getType() {
        return type;
    }
    public void setType(EAcademicUnitType type) {
        this.type = type;
    }
    public AcademicUnit getParent() {
        return parent;
    }
    public void setParent(AcademicUnit parent) {
        this.parent = parent;
    }
    public AcademicUnit() {
    }
    public AcademicUnit(UUID id, String code, String name, EAcademicUnitType type, AcademicUnit parent) {
        Id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    
}
