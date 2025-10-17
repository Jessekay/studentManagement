package com.example.Student.management.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_unit")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name = "academic_code", nullable = false, unique = true)
    private String code;

    private String name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnitType type;
    
    @ManyToOne
    @JoinColumn(name = "parent")
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
