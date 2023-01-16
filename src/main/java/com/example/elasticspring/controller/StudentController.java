package com.example.elasticspring.controller;

import com.example.elasticspring.entity.Student;
import com.example.elasticspring.repo.StudentRepository;
import com.example.elasticspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Student student){
        return ResponseEntity.ok(service.save(student));
    }

    @GetMapping("/")
    public ResponseEntity getStudentByName(@Param("name") String name){
        return ResponseEntity.ok(service.getStudent(name));
    }


}
