package com.nikhil.crud_revision.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student_info")
@Entity
public class Student {

    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_roll_number")
    private int roll_number;

    @Column(name = "student_department")
    private String department;

    @Column(name = "sex")
    private Sex sex;

    @Column(name = "student_college_name")
    private String college_name;


}
