package com.abe.demo.repositories.CustomMongoRepository;

import com.abe.demo.domains.common.UuidIdentifiedEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface CustomMongoRepository<T extends UuidIdentifiedEntity> extends MongoRepository<T, UUID> {

}
