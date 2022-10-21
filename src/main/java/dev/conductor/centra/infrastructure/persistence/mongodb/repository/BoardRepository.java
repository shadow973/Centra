package dev.conductor.centra.infrastructure.persistence.mongodb.repository;

import dev.conductor.centra.infrastructure.persistence.mongodb.entity.board.BoardEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BoardRepository extends MongoRepository<BoardEntity, String> {
    Optional<BoardEntity> getBoardById(String id);
}
