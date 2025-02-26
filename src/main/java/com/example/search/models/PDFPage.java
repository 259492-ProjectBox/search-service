package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class PDFPage {

    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("pdf_id")
    private int pdfId;

    @Field(type = FieldType.Integer)
    @SerializedName("page_number")
    private int pageNumber;

    @Field(type = FieldType.Text, analyzer = "thai")
    private String content;
}
