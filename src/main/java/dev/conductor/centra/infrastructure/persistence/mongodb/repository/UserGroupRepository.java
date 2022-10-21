package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.UserGroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserGroupRepository extends MongoRepository<UserGroupEntity, String> {

    UserGroupEntity findByName(String name);
}
