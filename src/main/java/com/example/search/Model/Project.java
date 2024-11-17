package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document(indexName = "project")
public class Project {

    @Id
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("old_project_no")
    private String oldProjectNo;

    @Field(type = FieldType.Keyword)
    @SerializedName("project_no")
    private String projectNo;

    @Field(type = FieldType.Text)
    @SerializedName("title_th")
    private String titleTH;

    @Field(type = FieldType.Text)
    @SerializedName("title_en")
    private String titleEN;

    @Field(type = FieldType.Text)
    @SerializedName("abstract")
    private String abstractText;

    @Field(type = FieldType.Keyword)
    @SerializedName("project_status")
    private String projectStatus;

    @Field(type = FieldType.Text)
    @SerializedName("relation_description")
    private String relationDescription;

    @Field(type = FieldType.Integer)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Integer)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Date)
    @SerializedName("created_at")
    private LocalDateTime createdAt;

    @Field(type = FieldType.Nested)
    private Employee advisor;

    @Field(type = FieldType.Nested)
    private Major major;

    @Field(type = FieldType.Nested)
    private Course course;

    @Field(type = FieldType.Nested)
    private Section section;

    @Field(type = FieldType.Nested)
    private List<Employee> committees;

    @Field(type = FieldType.Nested)
    private List<Student> members;
}
