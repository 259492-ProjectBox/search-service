package com.example.search.models;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Document(indexName = "pdfs")
public class PDF {

    @Id
    private int id;

    @Field(type = FieldType.Integer)
    private int resourceId;

    @Field(type = FieldType.Nested)
    private List<PDFPage> pages;
}
