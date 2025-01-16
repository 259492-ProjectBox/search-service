package com.example.search.consumers;

import com.example.search.dtos.ProjectMessage;
import com.example.search.models.Project;
import com.example.search.services.ProjectService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @Autowired
    ProjectService projectService;

    public void receiveMessage(byte[] message) {
        try {
            Gson gson = new GsonBuilder()
                    .create();
            String messageStr = new String(message);
            ProjectMessage projectMessage = gson.fromJson(messageStr, ProjectMessage.class);
            String operation = projectMessage.getOperation();
            Project project = projectMessage.getData();
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

        } catch (Exception e) {
            System.err.println("Error parsing or processing message: " + e.getMessage());
        }
    }
}
