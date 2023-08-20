package com.mcit.gradesubmisionjpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;

}
