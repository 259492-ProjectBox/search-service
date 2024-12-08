package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class PDF {

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
}