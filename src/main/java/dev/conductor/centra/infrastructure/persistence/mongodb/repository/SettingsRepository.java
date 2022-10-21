package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.SettingsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SettingsRepository extends MongoRepository<SettingsEntity, String> {
    SettingsEntity findOneByKey(String key);
}
