package com.example.search.services;

import com.example.search.models.Project;
import com.example.search.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    public void createProject(Project project) {
        projectRepository.save(project);
    }
    public void updateProject(Project project) {
        if (project.getId() == null) {
            throw new IllegalArgumentException("Project ID cannot be null for update");
        }
        projectRepository.save(project);
    }
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
