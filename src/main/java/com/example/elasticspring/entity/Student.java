package com.example.elasticspring.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "student")
public class Student {
    @Id
    String id;

    @Field(type = FieldType.Text, name = "name")
    String name;
}
