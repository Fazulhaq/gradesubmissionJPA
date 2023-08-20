package com.mcit.gradesubmisionjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grade")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "score", nullable = false)
    private String score;
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName="id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName="id")
    private Course course;
}
