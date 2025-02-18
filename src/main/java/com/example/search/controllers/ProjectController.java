package com.example.search.controllers;

import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "Projects API", description = "API for managing and searching projects")
public class ProjectController {
    private final ProjectService projectService;

    @Operation(summary = "Search projects by PDF content", description = "Provide a search input to search projects by their PDF content.")
    @GetMapping("/content")
    public ResponseEntity<?> searchProjectsByPDFContent(@RequestParam String searchInput) {
        try {
            List<Project> projects = projectService.getByPDFContent(searchInput);
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Search projects by all fields", description = "Search projects by specific fields and input value.")
    @GetMapping("/all-fields")
    public ResponseEntity<?> searchProjectsByAllFields(@RequestParam("fields") String fields,
                                                            @RequestParam("searchInput") String searchInput) {
        try {
            List<String> fieldList = Arrays.asList(fields.split(","));
            List<Project> projects = projectService.getProjectsByAllFields(fieldList, searchInput);
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @Operation(summary = "Search projects by all fields", description = "Search projects by specific fields and input value.")
    @GetMapping("/selected-fields")
    public ResponseEntity<?> searchProjectsBySelectedFields(@RequestParam("fields") String fields,
                                                       @RequestParam("searchInputs") String searchInputs) {
        try {
            List<String> fieldList = Arrays.asList(fields.split(","));
            List<String> searchInputList = Arrays.asList(searchInputs.split(","));
            List<Project> projects = projectService.getProjectsBySelectedFields(fieldList, searchInputList);
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    @Operation(summary = "Get project by ID", description = "Provide a project ID to retrieve the corresponding project.")
    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectsById(@PathVariable Integer projectId) {
        try {
            Optional<Project> project = projectService.getProjectById(projectId);
            return ResponseEntity.status(HttpStatus.OK).body(project);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
