package com.example.demo.repository;

import com.example.demo.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByName(String name);
}
