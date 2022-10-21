package dev.conductor.centra.domain.board.entity;

import dev.conductor.centra.domain.board.enums.BoardType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {

    private String id;
    private String name;
    private BoardType type;
    private List<String> projectIds = new ArrayList<>();
    private List<BoardColumn> boardColumns = new ArrayList<>();
    private String cql;

}
