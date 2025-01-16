package com.example.search.services;

import com.example.search.models.Project;
import com.example.search.models.ProjectResource;
import com.example.search.models.Resource;
import com.example.search.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProjectRepository projectRepository;
    private final UploadService uploadService;
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    private void setPresignedUrlsForProjectResources(List<ProjectResource> projectResources) {
        if (projectResources != null) {
            for (ProjectResource projectResource : projectResources) {
                Resource resource = projectResource.getResource();
                // Use .equals() for string comparison
                if (resource.getResourceType().getTypeName().equals("url")) {
                    continue;
                }
                String bucketName = "projects";
                String path = resource.getPath();
                String objectName = path.substring((bucketName + "/").length());
                projectResource.getResource().setUrl(uploadService.getPresignedURL(bucketName, objectName));
            }
        }
    }


    public List<Project> getPresignedURLForProjectResources(List<Project> projects) {
        if (projects == null || projects.isEmpty()) {
            return projects;
        }

        for (Project project : projects) {
            List<ProjectResource> projectResources = project.getProjectResources();
            setPresignedUrlsForProjectResources(projectResources);
        }

        return projects;
    }

    public List<Project> getProjectsBySelectedFields(List<String> fields, String searchInput) {
        Criteria criteria = new Criteria();
        for (String field : fields) {
            criteria = criteria.or(new Criteria(field).contains(searchInput));
        }

        Query searchQuery = new CriteriaQuery(criteria);
        final SearchHits<Project> searchResponse = elasticsearchOperations.search(searchQuery, Project.class);
        List<Project> projectList = new ArrayList<>();
        searchResponse.getSearchHits().forEach(hit -> {
            Project project = hit.getContent();
            projectList.add(project);
        });

        return getPresignedURLForProjectResources(projectList);
    }



    public List<Project> getByPDFContent(String input) {
        List<Project> projects = projectRepository.getByPDFContent(input);
        return getPresignedURLForProjectResources(projects);
    }

    public Optional<Project> getProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        project.ifPresent(p -> {
            List<ProjectResource> projectResources = p.getProjectResources();
            setPresignedUrlsForProjectResources(projectResources);
        });
        return project;
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
