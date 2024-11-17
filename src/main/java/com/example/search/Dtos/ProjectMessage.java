package com.example.search.Dtos;

import com.example.search.Model.Project;
import lombok.Data;

@Data
public class ProjectMessage {
    private String operation ;
    private Project data;
}
