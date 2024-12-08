package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Course {

    @SerializedName("id")
    private Integer id;

    @SerializedName("course_no")
    private String courseNo;

    @SerializedName("course_name")
    private String courseName;

    @SerializedName("major_id")
    private Integer majorId;

    @SerializedName("major")
    private Major major;
}
