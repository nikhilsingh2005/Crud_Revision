package com.nikhil.crud_revision.repositories;

import com.nikhil.crud_revision.entities.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(@NotBlank @Email String email);
}
