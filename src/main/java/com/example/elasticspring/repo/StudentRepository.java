package com.example.elasticspring.repo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.elasticspring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student,String> {
}
