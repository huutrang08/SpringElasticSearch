package com.example.elasticspring.repo;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.elasticspring.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepoCustom {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private final String indexName = "student";

    public String createOrUpdateDocument(Student student) throws IOException {

        IndexResponse response = elasticsearchClient.index(i -> i
                .index(indexName)
                .id(student.getId())
                .document(student)
        );
        if (response.result().name().equals("Created")) {
            return new StringBuilder("Document has been successfully created.").toString();
        } else if (response.result().name().equals("Updated")) {
            return new StringBuilder("Document has been successfully updated.").toString();
        }
        return new StringBuilder("Error while performing the operation.").toString();
    }


    public Student getDocumentById(String studentId) throws IOException{
        Student student = null;
        GetResponse<Student> response = elasticsearchClient.get(g -> g
                        .index(indexName)
                        .id(studentId),
                Student.class
        );

        if (response.found()) {
            student = response.source();
            System.out.println("Product name " + student.getName());
        } else {
            System.out.println ("Product not found");
        }

        return student;
    }

    public String deleteDocumentById(String productId) throws IOException {

        DeleteRequest request = DeleteRequest.of(d -> d.index(indexName).id(productId));

        DeleteResponse deleteResponse = elasticsearchClient.delete(request);
        if (Objects.nonNull(deleteResponse.result()) && !deleteResponse.result().name().equals("NotFound")) {
            return new StringBuilder("Product with id " + deleteResponse.id() + " has been deleted.").toString();
        }
        System.out.println("Product not found");
        return new StringBuilder("Product with id " + deleteResponse.id()+" does not exist.").toString();

    }

    public List<Student> searchAllDocuments() throws IOException {

        SearchRequest searchRequest =  SearchRequest.of(s -> s.index(indexName));
        SearchResponse searchResponse =  elasticsearchClient.search(searchRequest, Student.class);
        List<Hit> hits = searchResponse.hits().hits();
        List<Student> products = new ArrayList<>();
        for(Hit object : hits){

            System.out.print(((Student) object.source()));
            products.add((Student) object.source());

        }
        return products;
    }
}
