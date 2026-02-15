package org.example.infrastructure.console;

import org.example.domain.entity.Board;

public class BoardPrinter {
    public static void print (Board board){
        System.out.println();
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
            for (int column = 0; column < 9; column++) {
                if (column % 3 == 0) {
                    System.out.print("| ");
                }
                Integer value = board.getValue(row, column);
                System.out.print(value == null ? ". " : value + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }
}
