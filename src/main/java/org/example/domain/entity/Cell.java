package org.example.domain.entity;

public class Cell {
    private Integer value;
    private final boolean fixed;

    public Cell(Integer value, boolean fixed) {
        if (value != null && (value < 1 || value > 9)) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.value = value;
        this.fixed = fixed;
    }

    public void setValue(Integer value){
        if (fixed) {
            throw new IllegalStateException("Nao pode alterar célula fixa");
        }
        if (value != null && (value < 1 || value > 9)) {
            throw new IllegalArgumentException("Valor inválido.");
        }
    }


    public Integer getValue() {
        return value;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isEmpty() {
        return value == null;
    }
}
