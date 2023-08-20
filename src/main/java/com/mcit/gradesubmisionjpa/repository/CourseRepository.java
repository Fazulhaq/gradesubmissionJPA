package com.mcit.gradesubmisionjpa.repository;

import com.mcit.gradesubmisionjpa.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

}