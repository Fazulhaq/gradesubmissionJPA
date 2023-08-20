package com.mcit.gradesubmisionjpa.repository;

import com.mcit.gradesubmisionjpa.entity.Grade;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
        Optional<Grade> findByStudentIdAndCourseId(Long StudentId, Long CourseId);
        @Transactional
        void deleteByStudentIdAndCourseId(Long StudentId, Long CourseId);
        List<Grade> findByStudentId(Long StudentId);
        List<Grade> findByCourseId(Long CourseId);
}