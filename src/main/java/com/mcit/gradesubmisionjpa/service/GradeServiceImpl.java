package com.mcit.gradesubmisionjpa.service;

import java.util.List;

import com.mcit.gradesubmisionjpa.entity.Grade;
import com.mcit.gradesubmisionjpa.entity.Student;
import com.mcit.gradesubmisionjpa.repository.GradeRepository;
import com.mcit.gradesubmisionjpa.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


    private GradeRepository gradeRepository;
    private StudentRepository studentRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        grade.setStudent(student);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }

}
