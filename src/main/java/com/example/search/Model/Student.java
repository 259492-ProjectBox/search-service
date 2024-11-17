package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Data;

@Data
public class Student {

    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Text)
    @SerializedName("prefix")
    private String prefix;

    @Field(type = FieldType.Text)
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Text)
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Keyword)
    @SerializedName("email")
    private String email;
}