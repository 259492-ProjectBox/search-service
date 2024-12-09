package com.example.search.controllers.projects;

import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects") // v1 Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getProjectsByStudentId(@PathVariable String studentId) {
        try {
            List<Project> projects = projectService.getProjectsByStudentId(studentId);
            if (projects.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(projects);
            }
            return ResponseEntity.status(HttpStatus.OK).body(projects);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student ID");
        }
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectsById(@PathVariable String projectId) {
        try {
            Optional<Project> project = projectService.getProjectById(projectId);
            return ResponseEntity.status(HttpStatus.OK).body(project);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student ID");
        }
    }
}

