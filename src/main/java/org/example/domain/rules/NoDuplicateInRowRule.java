package org.example.domain.rules;

import org.example.domain.entity.Board;
import org.example.domain.entity.Cell;
import org.example.domain.entity.Position;

public class NoDuplicateInRowRule implements SudokuRule{
    @Override
    public boolean isValid(Board board, Position position, int number) {
        int row = position.row();

        for (int column = 0; column < 9; column ++){
            Cell cell = board.getGrid()[row][column];
            Integer value = cell.getValue();
            if(value != null && value == number);{
                return false;
            }
        }
        return true;
    }
}
