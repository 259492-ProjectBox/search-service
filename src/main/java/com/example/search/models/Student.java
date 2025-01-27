package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "students")
public class Student {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Text)
    @SerializedName("student_id")
    private String studentId;

    @Field(type = FieldType.Text)
    @SerializedName("sec_lab")
    private String secLab;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Text, analyzer = "thai")
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Text)
    @SerializedName("email")
    private String email;

    @Field(type = FieldType.Text)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Text)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Integer)
    @SerializedName("course_id")
    private Integer courseId;

    @Field(type = FieldType.Object)
    @SerializedName("course")
    private Course course;

    @Field(type = FieldType.Integer)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Object)
    @SerializedName("program")
    private Program program;
}
