package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
public class Staff {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("prefix_th")
    private String prefixTH;

    @Field(type = FieldType.Text)
    @SerializedName("prefix_en")
    private String prefixEN;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("first_name_th")
    private String firstNameTH;

    @Field(type = FieldType.Text , analyzer = "thai")
    @SerializedName("last_name_th")
    private String lastNameTH;

    @Field(type = FieldType.Text)
    @SerializedName("first_name_en")
    private String firstNameEN;

    @Field(type = FieldType.Text)
    @SerializedName("last_name_en")
    private String lastNameEN;

    @Field(type = FieldType.Text)
    @SerializedName("email")
    private String email;

    @Field(type = FieldType.Integer)
    @SerializedName("program_id")
    private Integer programId;

    @Field(type = FieldType.Object)
    @SerializedName("program")
    private Program program;

}
