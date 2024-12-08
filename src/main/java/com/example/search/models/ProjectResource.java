package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class ProjectResource {

    @SerializedName("id")
    private Integer id;

    @SerializedName("resource")
    private Resource resource;
}
