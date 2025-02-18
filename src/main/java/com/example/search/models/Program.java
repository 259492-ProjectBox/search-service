package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Program {
    @Id
    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private Integer id;

    @Field(type = FieldType.Keyword)
    @SerializedName("abbreviation")
    private String abbreviation;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_name_th")
    private String programNameTH;

    @Field(type = FieldType.Keyword)
    @SerializedName("program_name_en")
    private String programNameEN;
}
