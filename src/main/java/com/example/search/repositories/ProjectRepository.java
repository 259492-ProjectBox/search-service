package com.example.search.repositories;

import com.example.search.models.Project;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends ElasticsearchRepository<Project, String> {
}
