package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Data
public class PDFPage {

    @Id
    private int id;

    @Field(type = FieldType.Integer)
    @SerializedName("pdf_id")
    private int pdfId;

    @Field(type = FieldType.Integer)
    @SerializedName("page_number")
    private int pageNumber;

    @Field(type = FieldType.Text)
    private String content;

}
