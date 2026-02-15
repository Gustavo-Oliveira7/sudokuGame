package org.example;

import org.example.application.SudokuGame;
import org.example.domain.entity.Board;
import org.example.domain.entity.Position;
import org.example.domain.rules.NoDuplicateInBlockRule;
import org.example.domain.rules.NoDuplicateInColumnRule;
import org.example.domain.rules.NoDuplicateInRowRule;
import org.example.domain.rules.SudokuRule;
import org.example.domain.service.SudokuRuleValidator;
import org.example.infrastructure.console.BoardPrinter;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] initialBoard = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        Board board = new Board(initialBoard);

        List<SudokuRule> rules = List.of(
                new NoDuplicateInRowRule(),
                new NoDuplicateInColumnRule(),
                new NoDuplicateInBlockRule()
        );

        SudokuGame game = new SudokuGame(board, new SudokuRuleValidator(rules));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            BoardPrinter.print(board);
            if (game.isGameCompleted()) {
                System.out.println("Você completou o Sudoku!");
                break;
            }
            try {
                System.out.print("Linha (0-8): ");
                int row = scanner.nextInt();

                System.out.print("Coluna (0-8): ");
                int column = scanner.nextInt();

                System.out.print("Número (1-9): ");
                int number = scanner.nextInt();

                game.placeNumber(new Position(row, column), number);

            } catch (Exception error) {
                System.out.println("Erro: " + error.getMessage());
            }
        }
    }
}