package com.school;

public class Course {
    private int courseId;
    private String courseName;
    private static int idCounter = 100;

    public Course(String courseName) {
        this.courseName = courseName;
        this.courseId = idCounter++;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourse() {
        System.out.println("Course ID: " + courseId + ", Course Name: " + courseName);
    }
}
