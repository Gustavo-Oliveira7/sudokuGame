package org.example.domain.entity;

public record Position(int row, int column) {
    public Position {
        if (row < 0 || row > 8 || column < 0 || column > 8) {
            throw new IllegalArgumentException("Posição inválida no tabuleiro");
        }
    }
}
