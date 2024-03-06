package com.mowitnow.mower.model;

import java.util.ArrayList;
import java.util.List;

public class LawnMowerInstructions {
    private final List<InstructionEnum> instructions;

    public LawnMowerInstructions(String instructionString) {
        this.instructions = new ArrayList<>();
        for (char c : instructionString.toCharArray()) {
            switch (c) {
                case 'A' -> instructions.add(InstructionEnum.FORWARD);
                case 'D' -> instructions.add(InstructionEnum.RIGHT);
                case 'G' -> instructions.add(InstructionEnum.LEFT);
                default -> throw new IllegalArgumentException("Invalid instruction: " + c);
            }
        }
    }

    public List<InstructionEnum> getInstructions() {
        return instructions;
    }
}
