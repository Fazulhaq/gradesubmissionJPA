package com.mcit.gradesubmisionjpa.service;

import java.util.List;

import com.mcit.gradesubmisionjpa.entity.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public Course getCourse(Long id) {
        return null;
    }

    @Override
    public Course saveCourse(Course course) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {        
    }

    @Override
    public List<Course> getCourses() {
        return null;
    }

}