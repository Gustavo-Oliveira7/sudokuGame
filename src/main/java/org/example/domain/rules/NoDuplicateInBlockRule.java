package org.example.domain.rules;

import org.example.domain.entity.Board;
import org.example.domain.entity.Cell;
import org.example.domain.entity.Position;

public class NoDuplicateInBlockRule implements SudokuRule{
    @Override
    public boolean isValid(Board board, Position position, int number) {
        int startRow = (position.row() / 3) * 3;
        int startColumn = (position.column() / 3) * 3;
        /// parece ruim, mas é O(1)
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startColumn; col < startColumn + 3; col++) {

                Cell cell = board.getGrid()[row][col];
                Integer value = cell.getValue();

                if (value != null && value == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
