package com.mcit.gradesubmisionjpa.repository;

import com.mcit.gradesubmisionjpa.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
        Optional<Grade> findByStudentIdAndCourseId(Long StudentId, Long CourseId);
}