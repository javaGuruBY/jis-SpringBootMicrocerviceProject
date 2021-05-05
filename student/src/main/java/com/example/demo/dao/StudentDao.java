package com.example.demo.dao;

import com.example.demo.bean.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class StudentDao {

    private final EntityManager em;

    public Student getStudent() {
        return em.find(Student.class, 10L);
    }

}
