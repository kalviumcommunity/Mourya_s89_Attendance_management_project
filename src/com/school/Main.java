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
        // Create objects of Student, Teacher, Staff
        Student student1 = new Student("Alice", "Grade 10");
        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Staff staff1 = new Staff("John Doe", "Administrator");

        // Create Course
        Course course1 = new Course("Mathematics");

        // Call displayDetails() on each
        System.out.println("--- Person Hierarchy Demo ---");
        student1.displayDetails();
        System.out.println();
        teacher1.displayDetails();
        System.out.println();
        staff1.displayDetails();
        System.out.println();
        course1.displayCourse();

        // Attendance Log using student.getId()
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
        attendanceLog.add(record1);

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
