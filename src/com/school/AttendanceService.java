package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Overloaded markAttendance methods
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Error: Student or Course not found");
        }
    }

    // Overloaded displayAttendanceLog methods
    public void displayAttendanceLog() {
        System.out.println("=== All Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("=== Attendance Records for " + student.getName() + " ===");
        attendanceLog.stream()
            .filter(record -> record.getStudent().getId() == student.getId())
            .forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("=== Attendance Records for " + course.getCourseName() + " ===");
        attendanceLog.stream()
            .filter(record -> record.getCourse().getCourseId() == course.getCourseId())
            .forEach(AttendanceRecord::displayRecord);
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}