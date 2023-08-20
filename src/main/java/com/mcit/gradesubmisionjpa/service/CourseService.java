package com.mcit.gradesubmisionjpa.service;

import java.util.List;

import com.mcit.gradesubmisionjpa.entity.Course;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
}