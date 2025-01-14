package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class FileExtension {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("extension_name")
    private String extensionName;

    @Field(type = FieldType.Text)
    @SerializedName("mime_type")
    private String mimeType;
}
