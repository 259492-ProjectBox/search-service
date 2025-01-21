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
    @Field(type = FieldType.Text)
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Text, analyzer = "thai")
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Text)
    @SerializedName("email")
    private String email;

}
