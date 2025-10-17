package com.example.Student.management.model;

public class StudentRegistration {
    private String coursName;
    private String semesterName;
    public String getCoursName() {
        return coursName;
    }
    public void setCoursName(String coursName) {
        this.coursName = coursName;
    }
    public String getSemesterName() {
        return semesterName;
    }
    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }
    public StudentRegistration() {
    }
    public StudentRegistration(String coursName, String semesterName) {
        this.coursName = coursName;
        this.semesterName = semesterName;
    }

    
}
