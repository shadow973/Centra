package dev.conductor.centra.domain.board.dto;

import dev.conductor.centra.domain.board.enums.BoardType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBoardDto {
    private String name;
    private List<String> projectIds;
    private BoardType type;
}
