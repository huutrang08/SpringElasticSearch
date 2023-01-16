package com.example.elasticspring.repo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.elasticspring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,String> {

    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    Optional<Student> getStudent(String name);


}
