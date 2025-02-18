package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Course {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("course_no")
    private String courseNo;

    @Field(type = FieldType.Keyword)
    @SerializedName("course_name")
    private String courseName;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Nested)
    @SerializedName("program")
    private Program program;
}
