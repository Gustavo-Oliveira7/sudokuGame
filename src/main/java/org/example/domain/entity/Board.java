package org.example.domain.entity;

public class Board {
    private final Cell[][] grid;

    public Board(Cell[][] grid) {
        if (grid.length != 9) {
            throw new IllegalArgumentException("Tabuleiro inválido");
        }
        this.grid = grid;
    }

    public Cell getCell(Position position) {
        return grid[position.row()][position.column()];
    }

    public Integer getValue(Position position) {
        return getCell(position).getValue();
    }

    public void setValue(Position position, Integer value) {
        getCell(position).setValue(value);
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
