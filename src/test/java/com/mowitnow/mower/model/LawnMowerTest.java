package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    void testMoveForwardNorth() {
        // Arrange
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructions instructions = new LawnMowerInstructions("AD"); // Forward, Turn Right

        // Act
        mower.executeProgram(new Lawn(4, 5), instructions);

        // Assert
        assertEquals("3 4 E", mower.getPosition());
    }

    @Test
    void testMoveForwardEast() {
        // Arrange
        LawnMower mower = new LawnMower(2, 1, OrientationEnum.EAST);
        LawnMowerInstructions instructions = new LawnMowerInstructions("DA"); // Forward, Turn Right

        // Act
        mower.executeProgram(new Lawn(5, 8), instructions);

        // Assert
        assertEquals("2 0 S", mower.getPosition());
    }

    @Test
    void testMoveForwardSouth() {
        // Arrange
        Lawn lawn = new Lawn(8, 8);
        LawnMower mower = new LawnMower(5, 7, OrientationEnum.SOUTH);
        LawnMowerInstructions instructions = new LawnMowerInstructions("ADDA"); // Forward, Turn Right

        // Act
        mower.executeProgram(lawn, instructions);

        // Assert
        assertEquals("5 7 N", mower.getPosition());
    }

    @Test
    void testMoveForwardWest() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.WEST);
        LawnMowerInstructions instructions = new LawnMowerInstructions("AD"); // Forward, Turn Right

        // Act
        mower.executeProgram(lawn, instructions);

        // Assert
        assertEquals("2 3 N", mower.getPosition());
    }

    @Test
    void testMoveRight() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructions instructions = new LawnMowerInstructions("D"); // Turn Right

        // Act
        mower.executeProgram(lawn, instructions);

        // Assert
        assertEquals("3 3 E", mower.getPosition());
    }

    @Test
    void testMoveLeft() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructions instructions = new LawnMowerInstructions("G"); // Turn Left

        // Act
        mower.executeProgram(lawn, instructions);

        // Assert
        assertEquals("3 3 W", mower.getPosition());
    }

    @Test
    void testNoInstructions() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);

        // Act
        mower.executeProgram(lawn, null);

        // Assert
        assertEquals("3 3 N", mower.getPosition());
    }


    @Test
    void sanitizeMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.executeProgram(new Lawn(5, 5), null);
        assertEquals("1 2 N", mower.getPosition());

        mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.executeProgram(new Lawn(5, 5), new LawnMowerInstructions(""));
        assertEquals("1 2 N", mower.getPosition());
    }

    @Test
    void testMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.executeProgram(new Lawn(5, 5), new LawnMowerInstructions("GAGAGAGAA"));
        assertEquals("1 3 N", mower.getPosition());

        mower = new LawnMower(3, 3, OrientationEnum.EAST);
        mower.executeProgram(new Lawn(5, 5), new LawnMowerInstructions("AADAADADDA"));
        assertEquals("5 1 E", mower.getPosition());
    }

    @Test
    void testGetPosition() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        assertEquals("1 2 N", mower.getPosition());
    }
}
