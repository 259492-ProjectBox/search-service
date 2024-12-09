package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
public class Resource {

    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("title")
    private String title;

    @Field(type = FieldType.Text)
    @SerializedName("url")
    private String url;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;

    @Field(type = FieldType.Integer)
    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @Field(type = FieldType.Object)
    @SerializedName("resource_type")
    private ResourceType resourceType;
}
