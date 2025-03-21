package com.example.search.services;

import com.example.search.models.Project;
import com.example.search.models.ProjectResource;
import com.example.search.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightParameters;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                if (projectResource != null && projectResource.getResourceType() != null &&
                        projectResource.getResourceType().getTypeName().equals("url")) {
                    continue;
                }
                assert projectResource != null;
                String path = projectResource.getPath();
                assert path != null;
                String bucketName = "projects";
                String objectName = path.substring((bucketName + "/").length());
                projectResource.setUrl(uploadService.getPresignedURL(bucketName, objectName , projectResource.getFileExtension().getMimeType()));
            }
        }
    }

    public List<Project> getPresignedURLForProjectResources(List<Project> projects) {
        if (projects != null && !projects.isEmpty()) {
            for (Project project : projects) {
                List<ProjectResource> projectResources = project.getProjectResources();
                if (projectResources != null) {
                    setPresignedUrlsForProjectResources(projectResources);
                }
            }
        }
        return projects;
    }

    public List<Project> getProjectsBySelectedFields(List<String> fields, List<String> searchInputList) {
        Criteria criteria = buildCriteriaForMultipleInputs(fields, searchInputList);
        return executeSearchQuery(criteria);
    }

    public List<Project> getProjectsByAllFields(List<String> fields, String searchInput) {
        Criteria criteria = buildCriteriaForSingleInput(fields, searchInput);
        return executeSearchQuery(criteria);
    }

    private Criteria buildCriteriaForMultipleInputs(List<String> fields, List<String> searchInputList) {
        if (fields.size() != searchInputList.size()) {
            throw new IllegalArgumentException("Fields and searchInputList must have the same size");
        }

        Criteria criteria = new Criteria();
        for (int i = 0; i < fields.size(); i++) {
            String searchInput = searchInputList.get(i).trim().toLowerCase();

            if (searchInput.isEmpty()) {
                continue;
            }

            String[] subfields = fields.get(i).split("/");

            Criteria subCriteria = null;
            for (String subfield : subfields) {
                if (subfield.isEmpty()) {
                    continue;
                }

                if (subCriteria == null) {
                    subCriteria = new Criteria(subfield).contains(searchInput);
                } else {
                    subCriteria = subCriteria.or(new Criteria(subfield).contains(searchInput));
                }
            }

            if (subCriteria != null) {
                criteria = criteria.subCriteria(subCriteria);
            }
        }

        return criteria;
    }

    private Criteria buildCriteriaForSingleInput(List<String> fields, String searchInput) {
        Criteria criteria = new Criteria();
        searchInput = searchInput.trim().toLowerCase();

        for (String field : fields) {
            try {
                int numericValue = Integer.parseInt(searchInput);
                if (numericValue > 0) {
                    criteria = criteria.or(new Criteria(field).is(numericValue));
                }
            } catch (NumberFormatException e) {
                criteria = criteria.or(new Criteria(field).contains(searchInput));
            }
        }
        return criteria;
    }

    private List<Project> executeSearchQuery(Criteria criteria) {
        Query searchQuery = new CriteriaQuery(criteria);
        searchQuery.addSourceFilter(new FetchSourceFilterBuilder()
                .withIncludes("*")
                .withExcludes("projectResources.pdf")  // Uncomment if needed
                .build());

        final SearchHits<Project> searchResponse = elasticsearchOperations.search(searchQuery, Project.class);
        List<Project> projectList = searchResponse.getSearchHits().stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());

        return getPresignedURLForProjectResources(projectList);
    }

    public List<Project> getByPDFContent(String input) {
        List<SearchHit<Project>> searchHits = projectRepository.getByPDFContent(input);
        List<Project> projects = new ArrayList<>();

        for (SearchHit<Project> searchHit : searchHits) {
            Project project = searchHit.getContent();
            List<String> highlightedContents = searchHit.getHighlightField("projectResources.pdf.pages.content");
            project.setHighlightedContents(highlightedContents);
            projects.add(project);
        }

        return getPresignedURLForProjectResources(projects);
    }


    public Optional<Project> getProjectById(Integer id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            List<ProjectResource> projectResources = project.get().getProjectResources();
            setPresignedUrlsForProjectResources(projectResources);
        } else {
            System.out.println("Project not found with ID: " + id);
        }
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
