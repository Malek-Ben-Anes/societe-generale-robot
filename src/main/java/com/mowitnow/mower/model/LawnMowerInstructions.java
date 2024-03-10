package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.InstructionEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of instructions for a lawn mower
 */
public class LawnMowerInstructions {
    // List to store the instructions
    private final List<InstructionEnum> list;

    /**
     * Constructor to create a list of instructions from a string
     */
    public LawnMowerInstructions(String instruction) {
        this.list = new ArrayList<>();

        // Check if the instruction string is null or empty
        if (instruction == null || instruction.isBlank()) {
            return; // If empty, return an empty list of instructions
        }

        // Iterate through each character in the instruction string and convert it to an InstructionEnum
        for (char c : instruction.toCharArray()) {
            list.add(InstructionEnum.fromValue(c)); // Add the corresponding InstructionEnum to the list
        }
    }

    // Get the list of instructions
    public List<InstructionEnum> getList() {
        return list;
    }
}
