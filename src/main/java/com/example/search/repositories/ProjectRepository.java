package com.example.search.repositories;

import com.example.search.models.Project;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProjectRepository extends ElasticsearchRepository<Project, Integer> {

    @Query("""
        {
          "nested": {
            "path": "members",
            "query": {
              "wildcard": {
                "members.id": {
                  "value": "*?0*"
                }
              }
            }
          }
        }
        """)
    List<Project> findByStudentId(String studentId);

    @Query("""
        {
          "nested": {
            "path": "projectResources.resource.pdf.pages",
            "query": {
              "match": {
                "projectResources.resource.pdf.pages.content": {
                  "query": "?0",
                  "fuzziness": "AUTO"
                }
              }
            }
          }
        }
        """)
    List<Project> findByContentPDF(String input);



}
