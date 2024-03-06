package com.mowitnow.mower.model.enums;

import java.lang.reflect.Constructor;
import java.util.Arrays;

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

    /**
     * Static method to get enum from character
     */
    public static InstructionEnum fromValue(char value) {
        return Arrays.stream(values())
                .filter(instruction -> instruction.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No enum constant found for value: " + value));
    }
}
