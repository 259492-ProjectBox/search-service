package com.example.search;
import com.example.search.Adapters.LocalDateTimeTypeAdapter;
import com.example.search.Dtos.ProjectMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.concurrent.CountDownLatch;

@Getter
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(byte[] message) {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                    .create();

            String messageStr = new String(message);  // Convert byte[] to String
            ProjectMessage projectMessage = gson.fromJson(messageStr, ProjectMessage.class);

            System.out.println("Received Project: " + projectMessage.getData());

            // Decrement the latch count after processing
            latch.countDown();
        } catch (Exception e) {
            // Handle any exceptions during deserialization
            System.err.println("Error parsing message: " + e.getMessage());
        }
    }
}
