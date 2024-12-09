package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class PDF {

    @Field(type = FieldType.Text)
    @SerializedName("title")
    private String title;

    @Field(type = FieldType.Text)
    @SerializedName("content")
    private String content;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;
}