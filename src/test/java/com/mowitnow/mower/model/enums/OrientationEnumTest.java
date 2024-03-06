package com.mowitnow.mower.model.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrientationEnumTest {

    @Test
    public void testFromValueValid() {
        // Arrange
        char value = 'S';

        // Act
        OrientationEnum orientation = OrientationEnum.fromValue(value);

        // Assert
        assertEquals(OrientationEnum.SOUTH, orientation);
    }

    @Test
    public void testFromValueInvalid() {
        // Arrange
        char value = 'X'; // Invalid value

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> OrientationEnum.fromValue(value));
    }

    @Test
    public void testTurnRight() {
        // Arrange & Act
        OrientationEnum initialOrientation = OrientationEnum.NORTH;
        OrientationEnum nextOrientation = initialOrientation.turnRight().turnRight().turnRight();

        // Assert
        assertEquals(OrientationEnum.WEST, nextOrientation);
    }

    @Test
    public void testTurnLeft() {
        // Arrange & Act
        OrientationEnum initialOrientation = OrientationEnum.EAST;
        OrientationEnum nextOrientation = initialOrientation.turnLeft().turnLeft().turnLeft();

        // Assert
        assertEquals(OrientationEnum.SOUTH, nextOrientation);
    }
}
