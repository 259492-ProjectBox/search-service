package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
public class Employee {

    @SerializedName("id")
    private Integer id;

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("major_id")
    private Integer majorId;

    @SerializedName("major")
    private Major major;

    @SerializedName("projects")
    private List<Project> projects;
}
