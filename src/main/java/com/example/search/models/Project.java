package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("title_th")
    @Nullable
    private String titleTH;

    @Field(type = FieldType.Text)
    @SerializedName("title_en")
    @Nullable
    private String titleEN;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("abstract_text")
    @Nullable
    private String abstractText;

    @Field(type = FieldType.Text)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Text)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Text)
    @SerializedName("section_id")
    @Nullable
    private String sectionId;

    @Field(type = FieldType.Integer)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Object)
    @SerializedName("program")
    private Program program;

    @Field(type = FieldType.Integer)
    @SerializedName("course_id")
    private Integer courseId;

    @Field(type = FieldType.Object)
    @SerializedName("course")
    private Course course;

    @Field(type = FieldType.Nested)
    @SerializedName("staffs")
    private List<ProjectStaff> staffs;

    @Field(type = FieldType.Nested)
    @SerializedName("members")
    private List<Student> members;

    @Field(type = FieldType.Nested)
    @SerializedName("project_resources")
    private List<ProjectResource> projectResources;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;

    @Field(type = FieldType.Text)
    @SerializedName("updated_at")
    @Nullable
    private String updated_at;
}
