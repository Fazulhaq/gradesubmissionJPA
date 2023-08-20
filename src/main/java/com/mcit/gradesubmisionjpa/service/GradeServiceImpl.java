package com.mcit.gradesubmisionjpa.service;

import java.util.List;
import java.util.Optional;

import com.mcit.gradesubmisionjpa.entity.Course;
import com.mcit.gradesubmisionjpa.entity.Grade;
import com.mcit.gradesubmisionjpa.entity.Student;
import com.mcit.gradesubmisionjpa.exception.GradeNotFoundException;
import com.mcit.gradesubmisionjpa.repository.CourseRepository;
import com.mcit.gradesubmisionjpa.repository.GradeRepository;
import com.mcit.gradesubmisionjpa.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {


    private GradeRepository gradeRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    
    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()){
            return grade.get();
        }else {
            throw new GradeNotFoundException(studentId, courseId);
        }
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (grade.isPresent()){
            Grade unwrapedGrade = grade.get();
            unwrapedGrade.setScore(score);
            return gradeRepository.save(unwrapedGrade);
        }else {
            throw new GradeNotFoundException(studentId, courseId);
        }
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
