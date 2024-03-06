package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.InstructionEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LawnMowerInstructionsTest {

    @Test
    void testInstructionListCreation() {
        // Arrange
        String instructionString = "AGD";

        // Act
        LawnMowerInstructions instructionList = new LawnMowerInstructions(instructionString);

        // Assert
        assertEquals(3, instructionList.getList().size());
        assertEquals(InstructionEnum.FORWARD, instructionList.getList().get(0));
        assertEquals(InstructionEnum.LEFT, instructionList.getList().get(1));
        assertEquals(InstructionEnum.RIGHT, instructionList.getList().get(2));
    }

    @Test
    void testEmptyInstructionListCreation() {
        // Arrange
        String instructionString = "";

        // Act
        LawnMowerInstructions instructionList = new LawnMowerInstructions(instructionString);

        // Assert
        assertTrue(instructionList.getList().isEmpty());
    }

    @Test
    void testNullInstructionListCreation() {
        // Arrange
        String instructionString = null;

        // Act
        LawnMowerInstructions instructionList = new LawnMowerInstructions(instructionString);

        // Assert
        assertTrue(instructionList.getList().isEmpty());
    }

    @Test
    void testBlankInstructionListCreation() {
        // Arrange
        String instructionString = null;

        // Act
        LawnMowerInstructions instructionList = new LawnMowerInstructions("      ");

        // Assert
        assertTrue(instructionList.getList().isEmpty());
    }
}
