package com.mcit.gradesubmisionjpa.repository;

import com.mcit.gradesubmisionjpa.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}