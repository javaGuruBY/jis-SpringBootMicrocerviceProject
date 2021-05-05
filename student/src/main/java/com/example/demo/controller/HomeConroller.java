package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentService;
import com.example.demo.model.TutritHomeDto;
import com.example.demo.proxy.TutritProxy;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@RestController
public class HomeConroller {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TutritProxy tutritProxy;

    @GetMapping("/")
    public Student getHome() {
        return studentService.getBestStudent();
    }

    @GetMapping("/st/{lastName}")
    public Optional<Student> findByName(@PathVariable String name) {
        return Optional.of(studentRepository.findByName(name)).orElseThrow(EntityExistsException::new);
    }

    @GetMapping("/tutrit")
    public TutritHomeDto testTutrit() {
        return tutritProxy.getHome();
    }


}
