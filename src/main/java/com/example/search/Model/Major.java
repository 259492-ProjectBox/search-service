package com.example.search.Model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
public class Major {

    @Field(type = FieldType.Keyword)
    @SerializedName("id")
    private String id;

    @Field(type = FieldType.Text)
    @SerializedName("major_name")
    private String majorName;
}
