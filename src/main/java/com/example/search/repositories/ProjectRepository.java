package com.example.search.repositories;

import com.example.search.models.Project;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.annotations.SourceFilters;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends ElasticsearchRepository<Project, Integer> {

    @Query("""
        {
          "nested": {
            "path": "projectResources.pdf.pages",
            "query": {
              "bool": {
                "must": [
                  {
                    "match": {
                      "projectResources.resource.pdf.pages.content": {
                        "query": "?0",
                        "fuzziness": "AUTO"
                      }
                    }
                  }
                ]
              }
            }
          }
        }
        """)
    @SourceFilters(excludes = "*.pdf")
    List<Project> getByPDFContent(String input);


}
