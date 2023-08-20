package com.mcit.gradesubmisionjpa.repository;

import com.mcit.gradesubmisionjpa.entity.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
        Grade findByStudentId(Long StudentId);
}