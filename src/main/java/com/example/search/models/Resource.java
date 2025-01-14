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

    @Field(type = FieldType.Text, analyzer = "thai")
    @SerializedName("title")
    private String title;

    @Field(type = FieldType.Text)
    @SerializedName("resource_name")
    private String resourceName;

    @Field(type = FieldType.Text)
    @SerializedName("path")
    private String path;

    @Field(type = FieldType.Text)
    @SerializedName("url")
    private String url;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;

    @Field(type = FieldType.Nested)
    @SerializedName("pdf")
    private PDF pdf;

    @Field(type = FieldType.Integer)
    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @Field(type = FieldType.Object)
    @SerializedName("resource_type")
    private ResourceType resourceType;

    @Field(type = FieldType.Integer)
    @SerializedName("file_extension_id")
    private Integer fileExtensionId;

    @Field(type = FieldType.Object)
    @SerializedName("file_extension")
    private FileExtension file_extension;
}
