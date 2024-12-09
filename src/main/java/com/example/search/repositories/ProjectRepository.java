package com.example.search.repositories;

import com.example.search.models.Project;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends ElasticsearchRepository<Project, String> {
    // Custom query to find projects by student ID within the members list
    @Query("{\"nested\": {\"path\": \"members\", \"query\": {\"match\": {\"members.id\": \"?0\"}}}}")
    List<Project> findByStudentId(String studentId);

}
