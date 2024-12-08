package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(indexName = "projects")
public class Project {
    @Id
    @SerializedName("id")
    private Integer id;

    @SerializedName("project_no")
    private String projectNo;

    @SerializedName("title_th")
    private String titleTH;

    @SerializedName("title_en")
    private String titleEN;

    @SerializedName("abstract_text")
    private String abstractText;

    @SerializedName("academic_year")
    private Integer academicYear;

    @SerializedName("semester")
    private Integer semester;

    @SerializedName("is_approved")
    private Boolean isApproved;

    @SerializedName("created_at")
    private LocalDateTime createdAt;

    @SerializedName("section_id")
    private String sectionId;

    @SerializedName("major_id")
    private Integer majorId;

    @Field(type = FieldType.Nested, includeInParent = true)
    @SerializedName("major")
    private Major major;

    @Field(type = FieldType.Nested, includeInParent = true)
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
