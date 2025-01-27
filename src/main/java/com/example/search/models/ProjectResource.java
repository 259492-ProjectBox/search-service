package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Nullable;

@Data
public class ProjectResource {

    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text, analyzer = "thai")
    @SerializedName("title")
    @Nullable
    private String title;

    @Field(type = FieldType.Text)
    @SerializedName("resource_name")
    @Nullable
    private String resourceName;

    @Field(type = FieldType.Text)
    @SerializedName("path")
    @Nullable
    private String path;

    @Field(type = FieldType.Text)
    @SerializedName("url")
    @Nullable
    private String url;

    @Field(type = FieldType.Nested)
    @SerializedName("pdf")
    @Nullable
    private PDF pdf;

    @Field(type = FieldType.Integer)
    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @Field(type = FieldType.Object)
    @SerializedName("resource_type")
    private ResourceType resourceType;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;
}
