package com.example.search;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.example.search.repositories")
@SpringBootApplication
public class SearchApplication {
	private static final Logger logger = LoggerFactory.getLogger(SearchApplication.class);

	@Value("${spring.application.name}")
	private String appName;

	@Value("${spring.elasticsearch.uris}")
	private String elasticsearchUris;

	@Value("${rabbitmq.host}")
	private String rabbitmqHost;

	@Value("${minio.url}")
	private String minioUrl;
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SearchApplication.class);
		app.setAdditionalProfiles("dev");
		app.run(args);
	}

	// Log property values for debugging
	@PostConstruct
	public void logProperties() {
		logger.debug("Application Name: {}", appName);
		logger.debug("Elasticsearch URI: {}", elasticsearchUris);
		logger.debug("RabbitMQ Host: {}", rabbitmqHost);
		logger.debug("Minio URL: {}", minioUrl);
	}
}
