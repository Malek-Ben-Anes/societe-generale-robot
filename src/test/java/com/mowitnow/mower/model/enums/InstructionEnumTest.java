package com.mowitnow.mower.model.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstructionEnumTest {

    @Test
    void testGetValue() {
        // Arrange
        char expectedValue = 'A';

        // Act
        char actualValue = InstructionEnum.FORWARD.getValue();

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testFromValueValid() {
        // Arrange
        char value = 'G';

        // Act
        InstructionEnum instructionEnum = InstructionEnum.fromValue(value);

        // Assert
        assertEquals(InstructionEnum.LEFT, instructionEnum);
    }

    @Test
    void testFromValueInvalid() {
        // Arrange
        char value = 'X'; // Invalid value

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> InstructionEnum.fromValue(value));
    }
}
