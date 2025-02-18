package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "project_staffs")
public class ProjectStaff {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("prefix_th")
    private String prefixTH;

    @Field(type = FieldType.Text)
    @SerializedName("prefix_en")
    private String prefixEN;

    @Field(type = FieldType.Keyword)
    @SerializedName("first_name_th")
    private String firstNameTH;

    @Field(type = FieldType.Keyword)
    @SerializedName("last_name_th")
    private String lastNameTH;

    @Field(type = FieldType.Keyword)
    @SerializedName("first_name_en")
    private String firstNameEN;

    @Field(type = FieldType.Keyword)
    @SerializedName("last_name_en")
    private String lastNameEN;

    @Field(type = FieldType.Keyword)
    @SerializedName("email")
    private String email;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Nested)
    @SerializedName("program")
    private Program program;

    @Field(type = FieldType.Nested)
    @SerializedName("project_role")
    private ProjectRole projectRole;
}
