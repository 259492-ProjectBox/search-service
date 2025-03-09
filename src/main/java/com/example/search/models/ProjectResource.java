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

    @Field(type = FieldType.Keyword)
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

    @Field(type = FieldType.Text)
    @SerializedName("preview_url")
    @Nullable
    private String previewUrl;

    @Field(type = FieldType.Nested)
    @SerializedName("pdf")
    private PDF pdf;

    @Field(type = FieldType.Keyword)
    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @Field(type = FieldType.Object)
    @SerializedName("resource_type")
    private ResourceType resourceType;

    @Field(type = FieldType.Keyword)
    @SerializedName("file_extension_id")
    private String fileExtensionId;

    @Field(type = FieldType.Object)
    @SerializedName("file_extension")
    private FileExtension fileExtension;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;
}
