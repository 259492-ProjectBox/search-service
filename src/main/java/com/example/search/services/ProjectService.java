package com.example.search.services;

import com.example.search.models.Project;
import com.example.search.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getProjectsByStudentId(String studentId) {
        System.out.println(studentId);
        return projectRepository.findByStudentId(studentId);
    }
    public List<Project> getByContentPDF(String input) {
        return projectRepository.findByContentPDF(input);
    }
    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    public void updateProject(Project project) {
        if (project.getId() == null) {
            throw new IllegalArgumentException("Project ID cannot be null for update");
        }
        projectRepository.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}
