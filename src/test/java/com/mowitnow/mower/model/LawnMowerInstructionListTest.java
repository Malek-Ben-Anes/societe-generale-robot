package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.InstructionEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LawnMowerInstructionListTest {

    @Test
    void testInstructionListCreation() {
        // Arrange
        String instructionString = "AGD";

        // Act
        LawnMowerInstructionList instructionList = new LawnMowerInstructionList(instructionString);

        // Assert
        assertEquals(3, instructionList.getInstructions().size());
        assertEquals(InstructionEnum.FORWARD, instructionList.getInstructions().get(0));
        assertEquals(InstructionEnum.LEFT, instructionList.getInstructions().get(1));
        assertEquals(InstructionEnum.RIGHT, instructionList.getInstructions().get(2));
    }

    @Test
    void testEmptyInstructionListCreation() {
        // Arrange
        String instructionString = "";

        // Act
        LawnMowerInstructionList instructionList = new LawnMowerInstructionList(instructionString);

        // Assert
        assertTrue(instructionList.getInstructions().isEmpty());
    }

    @Test
    void testNullInstructionListCreation() {
        // Arrange
        String instructionString = null;

        // Act
        LawnMowerInstructionList instructionList = new LawnMowerInstructionList(instructionString);

        // Assert
        assertTrue(instructionList.getInstructions().isEmpty());
    }

    @Test
    void testBlankInstructionListCreation() {
        // Arrange
        String instructionString = null;

        // Act
        LawnMowerInstructionList instructionList = new LawnMowerInstructionList("      ");

        // Assert
        assertTrue(instructionList.getInstructions().isEmpty());
    }
}
