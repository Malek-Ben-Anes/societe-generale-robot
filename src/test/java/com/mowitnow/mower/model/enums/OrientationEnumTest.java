package com.mowitnow.mower.model.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrientationEnumTest {

    @Test
    void testFromValueValid() {
        // Arrange
        char value = 'S';

        // Act
        OrientationEnum orientation = OrientationEnum.fromValue(value);

        // Assert
        assertEquals(OrientationEnum.SOUTH, orientation);
    }

    @Test
    void testFromValueInvalid() {
        // Arrange
        char value = 'X'; // Invalid value

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> OrientationEnum.fromValue(value));
    }

    @Test
    void testTurnRight() {
        // Arrange & Act
        OrientationEnum initialOrientation = OrientationEnum.NORTH;
        OrientationEnum nextOrientation = initialOrientation.turnRight().turnRight().turnRight();

        // Assert
        assertEquals(OrientationEnum.WEST, nextOrientation);
    }

    @Test
    void testTurnLeft() {
        // Arrange & Act
        OrientationEnum initialOrientation = OrientationEnum.EAST;
        OrientationEnum nextOrientation = initialOrientation.turnLeft().turnLeft().turnLeft();

        // Assert
        assertEquals(OrientationEnum.SOUTH, nextOrientation);
    }
}
