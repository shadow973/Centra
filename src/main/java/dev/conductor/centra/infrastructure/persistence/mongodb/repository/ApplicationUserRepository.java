package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.ApplicationUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserRepository extends MongoRepository<ApplicationUserEntity, String> {
    ApplicationUserEntity findByUsername(String username);
    List<ApplicationUserEntity> findAll();
    ApplicationUserEntity findByEmailAddress(String emailAddress);
    Optional<ApplicationUserEntity> findById(String id);
    ApplicationUserEntity save(ApplicationUserEntity user);
}
