package com.example.search.dtos;

import com.example.search.models.Project;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProjectMessage {
    private String operation ;
    private Project data;
}
