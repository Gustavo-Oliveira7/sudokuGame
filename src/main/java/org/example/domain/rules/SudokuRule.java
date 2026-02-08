package org.example.domain.rules;

import org.example.domain.entity.Position;

public interface SudokuRule {
    boolean isValid(Board board, Position position, int number);
}
