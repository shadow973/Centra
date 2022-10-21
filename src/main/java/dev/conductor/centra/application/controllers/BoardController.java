package dev.conductor.centra.application.controllers;

import dev.conductor.centra.domain.board.api.BoardService;
import dev.conductor.centra.domain.board.dto.CreateBoardDto;
import dev.conductor.centra.domain.board.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController extends BaseController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Board createBoard(@RequestBody CreateBoardDto createBoardDto) {
        return boardService.createBoardFromDto(createBoardDto);
    }

    @GetMapping
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public Board findById(@PathVariable String id) {
        Board board = boardService.getById(id);

        if (board == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return board;
    }
}
