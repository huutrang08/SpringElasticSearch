package com.example.elasticspring.controller;

import com.example.elasticspring.repo.StudentRepository;
import com.example.elasticspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }
}
