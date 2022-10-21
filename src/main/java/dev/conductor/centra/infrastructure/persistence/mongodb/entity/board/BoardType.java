package dev.conductor.centra.infrastructure.persistence.mongodb.entity.board;

public enum BoardType {
    KANBAN("kanban"),
    SCRUM("scrum");

    private final String boardType;

    BoardType(String boardType) {
        this.boardType = boardType;
    }

    @Override
    public String toString() {
        return this.boardType;
    }
}
