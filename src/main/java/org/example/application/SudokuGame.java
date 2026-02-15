package org.example.application;

import org.example.domain.entity.Board;
import org.example.domain.entity.Position;
import org.example.domain.service.SudokuRuleValidator;

public class SudokuGame {

    private final Board board;
    private final SudokuRuleValidator validator;

    public SudokuGame(Board board, SudokuRuleValidator validator) {
        this.board = board;
        this.validator = validator;
    }

    public void placeNumber(Position position, int number) {
        validateNumberRange(number);
        if (!validator.isValid(board, position, number)) {
            throw new IllegalArgumentException(
                    "Não é possível inserir o número " + number +
                            " na posição (" + position.row() + ", " + position.column() + ")."
            );
        }
        board.setValue(position, number);
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("O número deve estar entre 1 e 9.");
        }
    }

    public boolean isGameCompleted(){
        if(board.hasEmptyCells()) {
            return false;
        }
        for(int row = 0; row < 9; row++){
            for(int column = 0; column < 9; column++) {
                Integer value = board.getValue(row,column);
                Position position = new Position(row, column);
                if (!validator.isValid(board, position, value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Board getBoard() {
        return board;
    }
}