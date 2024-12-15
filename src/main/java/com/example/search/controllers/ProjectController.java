package com.example.search.controllers;

import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("/content")
    public ResponseEntity<?> searchProjectsByPDFContent(@RequestParam String searchInput) {
        try {
            List<Project> projects = projectService.getByPDFContent(searchInput);
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/fields")
    public ResponseEntity<?> searchProjectsBySelectedFields(@RequestParam("fields[]") List<String> fields , @RequestParam("searchInput") String searchInput) {
        try {
            List<Project> projects = projectService.getProjectsBySelectedFields(fields , searchInput);
            return ResponseEntity.status(HttpStatus.OK).body(projects);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

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

