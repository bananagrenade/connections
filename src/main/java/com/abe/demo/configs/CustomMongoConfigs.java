package com.abe.demo.configs;

import com.abe.demo.repositories.CustomMongoRepository.CustomMongoRepositoryImpl;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(
        basePackages = "com.abe.demo.repository",
        repositoryBaseClass = CustomMongoRepositoryImpl.class)
public class CustomMongoConfigs {
}
