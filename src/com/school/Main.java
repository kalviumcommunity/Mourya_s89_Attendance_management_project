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
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create FileStorageService and AttendanceService instances
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Create and populate students (allStudents)
        ArrayList<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("Alice", "Grade 10"));
        allStudents.add(new Student("Bob", "Grade 11"));
        allStudents.add(new Student("Charlie", "Grade 9"));

        // Create and populate courses (allCourses)
        ArrayList<Course> allCourses = new ArrayList<>();
        allCourses.add(new Course("Mathematics"));
        allCourses.add(new Course("Physics"));
        allCourses.add(new Course("Chemistry"));

        // Demonstrate overloaded markAttendance methods
        System.out.println("=== Marking Attendance Using Different Methods ===");
        
        // Method 1: Using Student and Course objects
        attendanceService.markAttendance(allStudents.get(0), allCourses.get(0), "Present");
        attendanceService.markAttendance(allStudents.get(1), allCourses.get(1), "Absent");
        
        // Method 2: Using IDs with lookup
        attendanceService.markAttendance(allStudents.get(2).getId(), allCourses.get(2).getCourseId(), "Present", allStudents, allCourses);
        attendanceService.markAttendance(allStudents.get(0).getId(), allCourses.get(1).getCourseId(), "Present", allStudents, allCourses);

        // Demonstrate overloaded displayAttendanceLog methods
        System.out.println("\n=== Displaying Attendance Using Different Methods ===");
        
        // Display all records
        attendanceService.displayAttendanceLog();
        
        // Display records for specific student
        System.out.println();
        attendanceService.displayAttendanceLog(allStudents.get(0));
        
        // Display records for specific course
        System.out.println();
        attendanceService.displayAttendanceLog(allCourses.get(1));

        // Save attendance data
        attendanceService.saveAttendanceData();
        
        // Save other data
        storageService.saveData(allStudents, "students.txt");
        storageService.saveData(allCourses, "courses.txt");

        System.out.println("\nData saved successfully to files:");
        System.out.println("- students.txt");
        System.out.println("- courses.txt");
        System.out.println("- attendance_log.txt");
    }
}
