package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.annotation.Nullable;

@Data
@Document(indexName = "students")
public class Student {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("student_id")
    private String studentId;

    @Field(type = FieldType.Keyword)
    @SerializedName("sec_lab")
    private String secLab;

    @Field(type = FieldType.Keyword)
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Keyword)
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Keyword)
    @SerializedName("email")
    @Nullable
    private String email;

    @Field(type = FieldType.Text)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Text)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Nested)
    @SerializedName("program")
    private Program program;
}
