package org.example.domain.rules;

import org.example.domain.entity.Board;
import org.example.domain.entity.Cell;
import org.example.domain.entity.Position;

public class NoDuplicateInColumnRule implements SudokuRule{
    @Override
    public boolean isValid(Board board, Position position, int number) {
        int column = position.column();
        int currentRow = position.row();
        for(int row = 0; row <9 ; row++) {
            if (row == currentRow) continue;
            Cell cell = board.getGrid()[row][column];
            Integer value = cell.getValue();
            if (value != null && value.equals(number)) {
                throw new IllegalArgumentException("Erro: número " + number + " já existe na coluna " + column);
            }
        }
        return true;
    }
}
