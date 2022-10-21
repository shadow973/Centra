package dev.conductor.centra.infrastructure.persistence.mongodb.adapter;

import dev.conductor.centra.domain.board.entity.Board;
import dev.conductor.centra.domain.board.spi.BoardPersistencePort;
import dev.conductor.centra.infrastructure.persistence.mongodb.entity.board.BoardEntity;
import dev.conductor.centra.infrastructure.persistence.mongodb.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BoardPersistenceAdapter implements BoardPersistencePort {

    private final ModelMapper modelMapper;
    private final BoardRepository repository;

    public BoardPersistenceAdapter(ModelMapper modelMapper, BoardRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public Board findById(String id) {
        Optional<BoardEntity> entity = repository.getBoardById(id);

        return entity.map(
                boardEntity -> modelMapper.map(boardEntity, Board.class)
        ).orElse(null);
    }

    @Override
    public Board save(Board board) {
        return modelMapper.map(repository.save(modelMapper.map(board, BoardEntity.class)), Board.class);
    }

    @Override
    public List<Board> findAll() {
        return repository.findAll()
                .stream()
                .map(boardEntity -> modelMapper.map(boardEntity, Board.class))
                .collect(Collectors.toList());
    }
}
