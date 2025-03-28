package com.example.search.services;

import io.minio.MinioClient;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UploadService {

    @Autowired
    private MinioClient minioClient;

    public String getPresignedURL(String bucketName, String objectName , String fileExtension) {
        try {
            Map<String, String> reqParams = new HashMap<>();
            reqParams.put("response-content-type", fileExtension);

            int duration = 60 * 60;
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(duration)
                            .extraQueryParams(reqParams)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error occurred: " + e.getMessage());
        }
    }
}
