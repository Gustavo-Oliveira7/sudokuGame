package org.example.domain.rules;

import org.example.domain.entity.Board;
import org.example.domain.entity.Cell;
import org.example.domain.entity.Position;

public class NoDuplicateInColumnRule implements SudokuRule{
    @Override
    public boolean isValid(Board board, Position position, int number) {
        int column = position.column();
        for(int row = 0; row <9 ; row++) {
            Cell cell = board.getGrid()[row][column];
            Integer value = cell.getValue();
            if (value != null && value == number) {
                return false;
            }
        }
        return true;
    }
}
