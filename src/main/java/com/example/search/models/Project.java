package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.util.List;

@Data
@Document(indexName = "projects")
public class Project {

    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("project_no")
    private String projectNo;

    @Field(type = FieldType.Text)
    @SerializedName("title_th")
    private String titleTH;

    @Field(type = FieldType.Text)
    @SerializedName("title_en")
    private String titleEN;

    @Field(type = FieldType.Text)
    @SerializedName("abstract_text")
    private String abstractText;

    @Field(type = FieldType.Integer)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Integer)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Boolean)
    @SerializedName("is_approved")
    private Boolean isApproved;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String  createdAt;

    @Field(type = FieldType.Text)
    @SerializedName("section_id")
    private String sectionId;

    @Field(type = FieldType.Integer)
    @SerializedName("major_id")
    private Integer majorId;

    @Field(type = FieldType.Object)
    @SerializedName("major")
    private Major major;

    @Field(type = FieldType.Object)
    @SerializedName("course")
    private Course course;

    @Field(type = FieldType.Nested, includeInParent = true)
    @SerializedName("employees")
    private List<Employee> employees;

    @Field(type = FieldType.Nested, includeInParent = true)
    @SerializedName("members")
    private List<Student> members;

    @Field(type = FieldType.Nested, includeInParent = true)
    @SerializedName("project_resources")
    private List<ProjectResource> projectResources;
}
