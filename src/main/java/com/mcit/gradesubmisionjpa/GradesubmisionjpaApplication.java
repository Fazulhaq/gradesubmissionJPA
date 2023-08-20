package com.mcit.gradesubmisionjpa;

import com.mcit.gradesubmisionjpa.entity.Course;
import com.mcit.gradesubmisionjpa.entity.Student;
import com.mcit.gradesubmisionjpa.repository.CourseRepository;
import com.mcit.gradesubmisionjpa.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
@AllArgsConstructor
@SpringBootApplication
public class GradesubmisionjpaApplication implements CommandLineRunner {
	StudentRepository studentRepository;
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradesubmisionjpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[]{
				new Student("Ahmad", LocalDate.parse(("1988-08-14"))),
				new Student("Mahmood", LocalDate.parse(("1990-08-14"))),
				new Student("Akbar", LocalDate.parse(("1995-08-14"))),
				new Student("Mohammad", LocalDate.parse(("1970-08-14")))
		};
		for (int i =0; i< students.length; i++){
			studentRepository.save(students[i]);
		}
		Course[] courses = new Course[]{
				new Course("Math", "774MN","this the best course of the year"),
				new Course("History", "884MN","this the best course of the year"),
				new Course("Chemistry", "995MN","this the best course of the year"),
				new Course("Anatomy", "881MN","this the best course of the year"),
				new Course("English", "334MN","this the best course of the year")
		};
		for (int i =0; i< courses.length; i++){
			courseRepository.save(courses[i]);
		}
	}
}
