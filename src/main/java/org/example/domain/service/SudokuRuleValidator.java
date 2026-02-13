package org.example.domain.service;

import org.example.domain.entity.Board;
import org.example.domain.entity.Position;
import org.example.domain.rules.SudokuRule;

import java.util.List;

public class SudokuRuleValidator {
    private final List<SudokuRule> rules;

    public SudokuRuleValidator(List<SudokuRule> rules) {
        this.rules = rules;
    }

    public boolean isValid(Board board, Position position, int number) {
        for (SudokuRule rule : rules) {
            if (!rule.isValid(board, position, number)) {
                return false;
            }
        }
        return true;
    }
}
