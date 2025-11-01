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

import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== School Directory ===");
        List<Person> people = regService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create service instances with dependency injection
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Register students using RegistrationService
        registrationService.registerStudent("Alice", "Grade 10");
        registrationService.registerStudent("Bob", "Grade 11");
        registrationService.registerStudent("Charlie", "Grade 9");

        // Register teachers using RegistrationService
        registrationService.registerTeacher("Dr. Smith", "Mathematics");
        registrationService.registerTeacher("Ms. Johnson", "Physics");

        // Register staff using RegistrationService
        registrationService.registerStaff("John Doe", "Librarian");
        registrationService.registerStaff("Jane Wilson", "Administrator");

        // Create courses using RegistrationService
        registrationService.createCourse("Mathematics");
        registrationService.createCourse("Physics");
        registrationService.createCourse("Chemistry");

        // Display school directory using polymorphism
        displaySchoolDirectory(registrationService);

        // Demonstrate overloaded markAttendance methods
        System.out.println("=== Marking Attendance Using Different Methods ===");
        
        // Method 1: Using Student and Course objects
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        
        // Method 2: Using IDs with lookup (now handled by RegistrationService)
        attendanceService.markAttendance(students.get(2).getId(), courses.get(2).getCourseId(), "Present");
        attendanceService.markAttendance(students.get(0).getId(), courses.get(1).getCourseId(), "Present");

        // Demonstrate overloaded displayAttendanceLog methods
        System.out.println("\n=== Displaying Attendance Using Different Methods ===");
        
        // Display all records
        attendanceService.displayAttendanceLog();
        
        // Display records for specific student
        System.out.println();
        attendanceService.displayAttendanceLog(students.get(0));
        
        // Display records for specific course
        System.out.println();
        attendanceService.displayAttendanceLog(courses.get(1));

        // Save all data using respective services
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nData saved successfully to files:");
        System.out.println("- students.txt");
        System.out.println("- teachers.txt");
        System.out.println("- staff.txt");
        System.out.println("- courses.txt");
        System.out.println("- attendance_log.txt");
    }
}
