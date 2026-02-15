package org.example.domain.entity;


public class Board {
    private final Cell[][] grid;

    public Board(int[][] initialValues) {
        if (initialValues.length != 9) {
            throw new IllegalArgumentException("Tabuleiro inválido");
        }
        this.grid = new Cell[9][9];
        for (int row = 0; row < 9; row++) {
            if (initialValues[row].length != 9) {
                throw new IllegalArgumentException("Cada linha deve ter 9 colunas.");
            }
            for (int column = 0; column < 9; column++) {
                int value = initialValues[row][column];
                if (value == 0) {
                    grid[row][column] = new Cell(null, false);
                } else {
                    grid[row][column] = new Cell(value, true);
                }
            }
        }
    }

    public boolean hasEmptyCells() {
        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column++){
                if (grid[row][column].isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }


    public Cell getCell(Position position) {
        return grid[position.row()][position.column()];
    }

    public Integer getValue(int row, int column) {
        return grid[row][column].getValue();
    }

    public void setValue(Position position, Integer value) {
        grid[position.row()][position.column()].setValue(value);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public boolean isCellFixed(Position position) {
        return grid[position.row()][position.column()].isFixed();
    }

}
