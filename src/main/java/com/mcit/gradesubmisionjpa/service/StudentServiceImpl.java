package com.mcit.gradesubmisionjpa.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.mcit.gradesubmisionjpa.entity.Course;
import com.mcit.gradesubmisionjpa.entity.Student;
import com.mcit.gradesubmisionjpa.exception.CourseNotFoundException;
import com.mcit.gradesubmisionjpa.exception.StudentNotFoundException;
import com.mcit.gradesubmisionjpa.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Set<Course> getEnrolledCourses(Long studentId) {
        Student student = getStudent(studentId);
        return student.getCourses();
    }

    static Student unwrapStudent(Optional<Student> entity, Long id){
        if (entity.isPresent()) return entity.get();
        else throw new StudentNotFoundException(id);
    }
}