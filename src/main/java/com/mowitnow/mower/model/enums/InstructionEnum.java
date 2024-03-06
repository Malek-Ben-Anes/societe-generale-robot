package com.mowitnow.mower.model.enums;

public enum InstructionEnum {
    // Avance
    FORWARD('A'),

    // Droite
    RIGHT('D'),

    // Gauche
    LEFT('G');

    private final char value;

    InstructionEnum(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    // Static method to get enum from character
    public static InstructionEnum fromValue(char value) {
        for (InstructionEnum instruction : InstructionEnum.values()) {
            if (instruction.getValue() == value) {
                return instruction;
            }
        }
        throw new IllegalArgumentException("No enum constant found for value: " + value);
    }
}
