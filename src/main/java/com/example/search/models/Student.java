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
    @Field(type = FieldType.Text) // Ensuring full-text search on the id field
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Text) // Full-text search on prefix
    @SerializedName("prefix")
    private String prefix;

    @Field(type = FieldType.Text) // Full-text search on firstName
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Text) // Full-text search on lastName
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Text) // Full-text search on email
    @SerializedName("email")
    private String email;

    @Field(type = FieldType.Integer) // Major ID as integer (not a text field)
    @SerializedName("major_id")
    private Integer majorId;

    @Field(type = FieldType.Object) // Major as a nested object
    @SerializedName("major")
    private Major major;
}
