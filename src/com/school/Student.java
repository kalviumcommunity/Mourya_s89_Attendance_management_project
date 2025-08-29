package com.school;

public class Student {
    private int studentId;
    private String name;
    private static int idCounter = 1;

    public Student(String name) {
        this.name = name;
        this.studentId = idCounter++;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void displayStudent() {
        System.out.println("Student ID: " + studentId + ", Name: " + name);
    }
}
