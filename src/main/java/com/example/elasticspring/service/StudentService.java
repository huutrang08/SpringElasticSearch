package com.example.elasticspring.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.elasticspring.entity.Student;
import com.example.elasticspring.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public <S extends Student> S save(S entity) {
        return studentRepository.save(entity);
    }

    public Optional<Student> findById(String s) {
        return studentRepository.findById(s);
    }

    public Optional<Student> getStudent(String name) {
        return studentRepository.getStudent(name);
    }
}
