package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Course {

    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Keyword)
    @SerializedName("course_no")
    private String courseNo;

    @Field(type = FieldType.Text)
    @SerializedName("course_name")
    private String courseName;
}
