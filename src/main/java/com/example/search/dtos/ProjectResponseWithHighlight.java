package com.example.search.dtos;


import com.example.search.models.*;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.annotation.Nullable;
import java.util.List;

@Data
public class ProjectResponseWithHighlight {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("project_no")
    private String projectNo;

    @Field(type = FieldType.Keyword)
    @SerializedName("title_th")
    @Nullable
    private String titleTH;

    @Field(type = FieldType.Keyword, normalizer = "lowercase")
    @SerializedName("title_en")
    @Nullable
    private String titleEN;

    @Field(type = FieldType.Keyword, normalizer = "lowercase")
    @SerializedName("abstract_text")
    @Nullable
    private String abstractText;

    @Field(type = FieldType.Text)
    @SerializedName("academic_year")
    private Integer academicYear;

    @Field(type = FieldType.Text)
    @SerializedName("semester")
    private Integer semester;

    @Field(type = FieldType.Keyword)
    @SerializedName("section_id")
    @Nullable
    private String sectionId;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Nested)
    @SerializedName("program")
    private Program program;

    @Field(type = FieldType.Nested)
    @SerializedName("staffs")
    private List<Staff> staffs;

    @Field(type = FieldType.Nested)
    @SerializedName("members")
    private List<Student> members;

    @Field(type = FieldType.Nested)
    @SerializedName("project_resources")
    private List<ProjectResource> projectResources;

    @Field(type = FieldType.Boolean)
    @SerializedName("is_public")
    private Boolean isPublic;

    @Field(type = FieldType.Nested)
    @SerializedName("keywords")
    private List<Keyword> keywords;

    @Field(type = FieldType.Text)
    @SerializedName("created_at")
    private String createdAt;

    @Field(type = FieldType.Text)
    @SerializedName("updated_at")
    @Nullable
    private String updatedAt;

    @Field(type = FieldType.Object)
    @SerializedName("highlight")
    Highlight highlight;
}
