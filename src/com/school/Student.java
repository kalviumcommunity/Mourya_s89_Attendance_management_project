package com.school;

public class Student {
    int StudentId;
    String name;

    public void setDetails(int id,String StudentName){
        this.StudentId=id;
        this.name = StudentName;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.StudentId + ", Name: "+this.name);}
}