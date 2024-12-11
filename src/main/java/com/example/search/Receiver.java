package com.example.search;

import com.example.search.dtos.ProjectMessage;
import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

@Component
@RequiredArgsConstructor
public class Receiver {

    private final ProjectService projectService;
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {
        try {
            Gson gson = new GsonBuilder()
                    .create();

            String messageStr = new String(message);
            ProjectMessage projectMessage = gson.fromJson(messageStr, ProjectMessage.class);

            String operation = projectMessage.getOperation();
            Project project = projectMessage.getData();
            System.out.println(project.getProjectResources());
            switch (operation.toLowerCase()) {
                case "create":
                    projectService.createProject(project);
                    System.out.println("Project created");
                    break;

                case "update":
                    projectService.updateProject(project);
                    System.out.println("Project updated");
                    break;

                case "delete":
                    projectService.deleteProject(project.getId());
                    System.out.println("Project deleted with ID");
                    break;

                default:
                    System.out.println("Unknown operation");
                    break;
            }

            // Decrement the latch count after processing
            latch.countDown();
        } catch (Exception e) {
            System.err.println("Error parsing or processing message: " + e.getMessage());
        }
    }

}
