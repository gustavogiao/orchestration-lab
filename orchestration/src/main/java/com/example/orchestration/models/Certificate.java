package com.example.orchestration.models;

public class Certificate {
    private int studentId;
    private String name;
    private String course;

    public Certificate() {}

    public Certificate(int studentId, String name, String course){
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
}