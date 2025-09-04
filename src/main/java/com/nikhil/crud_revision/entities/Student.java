package com.nikhil.crud_revision.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"email", "id"})
@Table(name = "student_info")
@Entity
public class Student {

    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 5, max = 50)
    @Column(name = "student_name", nullable = false)
    private String name;

    @Positive
    @Column(name = "student_roll_number", unique = true, nullable = false)
    private Integer rollNumber;

    @NotBlank
    @Size(min = 5, max = 50)
    @Column(name = "student_department", nullable = false)
    private String department;

    @NotNull(message = "Sex is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "student_sex", nullable = false)
    private Sex sex;

    @Past
    @Column(name = "student_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank
    @Email(message = "Email should be valid")
    @Column(name = "student_email", unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(min = 10, max = 50)
    @Column(name = "student_college_name", nullable = false)
    private String collegeName;

}
