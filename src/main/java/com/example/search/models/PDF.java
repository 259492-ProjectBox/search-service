package com.example.search.models;

import com.google.gson.annotations.SerializedName;
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
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Integer)
    @SerializedName("resource_id")
    private int resourceId;

    @Field(type = FieldType.Nested)
    private List<PDFPage> pages;
}
