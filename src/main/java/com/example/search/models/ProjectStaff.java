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

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("prefix")
    private String prefix;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("first_name")
    private String firstName;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("last_name")
    private String lastName;

    @Field(type = FieldType.Text)
    @SerializedName("email")
    private String email;

    @Field(type = FieldType.Integer)
    @SerializedName("major_id")
    private Integer majorId;

    @Field(type = FieldType.Nested)
    @SerializedName("program")
    private Program program;

    @Field(type = FieldType.Nested)
    @SerializedName("project_role")
    private ProjectRole projectRole;

}
