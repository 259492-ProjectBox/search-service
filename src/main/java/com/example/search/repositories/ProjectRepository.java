package com.example.search.repositories;

import com.example.search.models.Project;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.SearchHit;
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
                "match": {
                    "projectResources.pdf.pages.content": {
                        "query": "?0",
                        "fuzziness": "AUTO"
                    }
                }
            }
        }
    }
""")
    @Highlight(fields = {
            @HighlightField(name = "projectResources.pdf.pages.content")
            },
            parameters = @HighlightParameters(
                    preTags = "<p class=\"pdf-content\">",
                    postTags = "</p>",
                    fragmentSize = 500,
                    numberOfFragments = 1
            ))
    @SourceFilters(excludes = "*.pdf")
    List<SearchHit<Project>> getByPDFContent(String input);
}
