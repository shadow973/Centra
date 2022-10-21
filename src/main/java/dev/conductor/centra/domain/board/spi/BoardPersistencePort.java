package dev.conductor.centra.domain.board.spi;

import dev.conductor.centra.domain.board.entity.Board;

import java.util.List;

public interface BoardPersistencePort {
    Board findById(String id);
    Board save(Board board);
    List<Board> findAll();
}
