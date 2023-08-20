package com.mcit.gradesubmisionjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NonNull
    @Column(name = "subject", nullable = false)
    private String subject;
    @NonNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

}
