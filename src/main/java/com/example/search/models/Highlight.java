package com.example.search.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
public class Highlight {

    @Field(type = FieldType.Text)
    @SerializedName("projectResources.pdf.pages.content")
    private List<String> pdfContentHighlight;
}
