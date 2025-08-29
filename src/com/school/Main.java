// package com.school;

// public class Main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the School Attendance System Project!");
//         System.out.println("Session 1: Project Setup and Orientation Complete.");
//     }
// }


// package com.school;

// public class Main {
//     public static void main(String[] args) {
//         System.out.println("--- School Attendance System ---");

//         Student[] students = new Student[4];
//         students[0] = new Student("Alice Wonderland");
//         students[1] = new Student("Bob the builder");
//         students[2] = new Student("Charlie Chaplin");
//         students[3] = new Student("Dora Explorer");

//         Course[] courses = new Course[3];
//         courses[0] = new Course("Intro to programming");
//         courses[1] = new Course("Linear Algebra");
//         courses[2] = new Course("Physics 101");

//         System.out.println("\nRegistered Students: ");
//         for(Student student : students) {
//             if(student != null) student.displayDetails();
//         }

//         System.out.println("\nAvailable Courses: ");
//         for(Course course : courses) {
//             if (course != null) course.displayDetails();
//         }
//         System.out.println("\nSession 3: Constructors and Auto-ID Generation Complete");
//     }
// }
package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Create Courses
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        // Display for reference
        student1.displayStudent();
        student2.displayStudent();
        course1.displayCourse();
        course2.displayCourse();

        // Attendance Log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Create Attendance Records
        AttendanceRecord record1 = new AttendanceRecord(student1.getStudentId(), course1.getCourseId(), "Present");
        AttendanceRecord record2 = new AttendanceRecord(student2.getStudentId(), course2.getCourseId(), "Absent");
        AttendanceRecord record3 = new AttendanceRecord(student1.getStudentId(), course2.getCourseId(), "Late"); // Invalid

        // Add to list
        attendanceLog.add(record1);
        attendanceLog.add(record2);
        attendanceLog.add(record3);

        // Display all records
        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
