package com.example.demo.dao;

import com.example.demo.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureTestEntityManager
@Transactional
class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Test
    @Sql("/getHomeTestData.sql")
    void getStudent() {
        Student student = studentDao.getStudent();
    }
}
