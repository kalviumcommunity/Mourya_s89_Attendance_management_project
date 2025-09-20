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

public class Main {
    public static void main(String[] args) {
        // Create and populate students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Grade 10"));
        students.add(new Student("Bob", "Grade 11"));
        students.add(new Student("Charlie", "Grade 9"));

        // Create and populate courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));

        // Create and populate attendance records
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        records.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "Present"));

        // Create FileStorageService instance
        FileStorageService storageService = new FileStorageService();

        // Save data to files
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");

        System.out.println("Data saved successfully to files:");
        System.out.println("- students.txt");
        System.out.println("- courses.txt");
        System.out.println("- attendance_log.txt");
    }
}
