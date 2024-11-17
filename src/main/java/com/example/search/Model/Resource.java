package com.example.search.Model;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(indexName = "resources")
public class Resource {

    @Id
    private Integer id;

    @Field(type = FieldType.Text)
    @SerializedName("title")
    private String title;

    @Field(type = FieldType.Integer)
    @SerializedName("project_id")
    private Integer projectId;

    @Field(type = FieldType.Integer)
    @SerializedName("resource_type_id")
    private Integer resourceTypeId;

    @Field(type = FieldType.Text)
    @SerializedName("url")
    private String url;

    @Field(type = FieldType.Date)
    @SerializedName("created_at")
    private LocalDateTime createdAt;

    @Field(type = FieldType.Object)
    @SerializedName("project")
    private Project project;

    @Field(type = FieldType.Object)
    @SerializedName("resource_type")
    private ResourceType resourceType;

    @Field(type = FieldType.Nested)
    @SerializedName("content")
    private List<PDF> content;
}