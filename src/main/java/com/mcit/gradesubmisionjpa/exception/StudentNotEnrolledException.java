package com.mcit.gradesubmisionjpa.exception;

public class StudentNotEnrolledException extends RuntimeException{
    public StudentNotEnrolledException(Long studentId, Long courseId) {
        super("The student id '" + studentId + "' does not enrolled with course id '"+ courseId +"' in our records");
    }
}
