package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "resource_types")
public class ResourceType {

    @Id
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("resource_type")
    private String resourceType;
}