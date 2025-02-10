package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "project_roles")
public class ProjectRole {

    @Id
    @Field(type = FieldType.Keyword )
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text, analyzer = "thai")
    @SerializedName("role_name_th")
    private String roleNameTH;

    @Field(type = FieldType.Text)
    @SerializedName("role_name_en")
    private String roleNameEN;

}
