package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Section {

    @Id
    private int id;

    @Field(type = FieldType.Keyword)
    @SerializedName("section_number")
    private String sectionNumber;

    @Field(type = FieldType.Integer)
    @SerializedName("semester")
    private int semester;
}