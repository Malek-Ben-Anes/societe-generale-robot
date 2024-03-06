package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.InstructionEnum;

import java.util.ArrayList;
import java.util.List;

public class LawnMowerInstructionList {
    private final List<InstructionEnum> instructions;

    public LawnMowerInstructionList(String instructionString) {
        this.instructions = new ArrayList<>();
        for (char c : instructionString.toCharArray()) {
            instructions.add(InstructionEnum.fromValue(c));
        }
    }

    public List<InstructionEnum> getInstructions() {
        return instructions;
    }
}
