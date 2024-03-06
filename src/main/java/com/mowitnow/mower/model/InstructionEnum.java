package com.mowitnow.mower.model;

public enum InstructionEnum {
    FORWARD('A'),
    RIGHT('D'),
    LEFT('G');

    private final char symbol;

    InstructionEnum(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
