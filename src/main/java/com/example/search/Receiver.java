package com.example.search;

import com.example.search.adapters.LocalDateTimeTypeAdapter;
import com.example.search.dtos.ProjectMessage;
import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

@Component
@RequiredArgsConstructor
public class Receiver {

    private final ProjectService projectService;
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                    .create();

            String messageStr = new String(message);
            ProjectMessage projectMessage = gson.fromJson(messageStr, ProjectMessage.class);
            System.out.println("Received Project: " + projectMessage.getData());

            String operation = projectMessage.getOperation();
            Project project = projectMessage.getData();

            switch (operation.toLowerCase()) {
                case "create":
                    projectService.createProject(project);
                    System.out.println("Project created: " + project);
                    break;

                case "update":
                    projectService.updateProject(project);
                    System.out.println("Project updated: " + project);
                    break;

                case "delete":
                    projectService.deleteProject(project.getId().toString());
                    System.out.println("Project deleted with ID: " + project.getId());
                    break;

                default:
                    System.out.println("Unknown operation: " + operation);
                    break;
            }

            // Decrement the latch count after processing
            latch.countDown();
        } catch (Exception e) {
            System.err.println("Error parsing or processing message: " + e.getMessage());
        }
    }

}
