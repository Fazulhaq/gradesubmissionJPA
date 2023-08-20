package com.mcit.gradesubmisionjpa.service;

import java.util.List;
import java.util.Optional;

import com.mcit.gradesubmisionjpa.entity.Course;
import com.mcit.gradesubmisionjpa.entity.Grade;
import com.mcit.gradesubmisionjpa.entity.Student;
import com.mcit.gradesubmisionjpa.exception.CourseNotFoundException;
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
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Student student = StudentServiceImpl.unwrapStudent(studentRepository.findById(studentId), studentId);
        Course course = CourseServiceImpl.unwrapCourse(courseRepository.findById(courseId), courseId);
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        Grade unwrapedGrade = unwrapGrade(grade, studentId, courseId);
        unwrapedGrade.setScore(score);
        return gradeRepository.save(unwrapedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
    static Grade unwrapGrade(Optional<Grade> entity, Long StudentId, Long CourseId){
        if (entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(StudentId, CourseId);
    }

}
