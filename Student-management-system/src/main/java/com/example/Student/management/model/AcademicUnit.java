package com.example.Student.management.model;

import java.util.UUID;

public class AcademicUnit {
    private UUID Id;
    private String code;
    private String name;
    private EAcademicUnitType type;
    private AcademicUnit parent;
}
