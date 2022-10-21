package dev.conductor.centra.domain.board.api;

import dev.conductor.centra.domain.board.dto.CreateBoardDto;
import dev.conductor.centra.domain.board.entity.Board;

import java.util.List;

public interface BoardService {

    Board getById(String id);
    List<Board> findAll();
    Board createBoardFromDto(CreateBoardDto dto);
}
