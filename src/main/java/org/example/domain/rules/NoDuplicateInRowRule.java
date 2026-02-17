package org.example.domain.rules;

import org.example.domain.entity.Board;
import org.example.domain.entity.Cell;
import org.example.domain.entity.Position;

public class NoDuplicateInRowRule implements SudokuRule{
    @Override
    public boolean isValid(Board board, Position position, int number) {
        int row = position.row();
        int col = position.column();

        for (int column = 0; column < 9; column ++){
            if(column == col) continue;;
            Cell cell = board.getGrid()[row][column];
            Integer value = cell.getValue();
            if(value != null && value.equals(number)){
                throw new IllegalArgumentException("Erro: número " + number + " já existe na linha " + row);
            }
        }
        return true;
    }
}
