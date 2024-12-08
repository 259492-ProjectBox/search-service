package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class Resource {

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("created_at")
    private LocalDateTime createdAt;

    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @SerializedName("resource_type")
    private ResourceType resourceType;
}
