package com.mowitnow.mower.model;

import com.mowitnow.mower.model.enums.OrientationEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    void testMoveForwardNorth() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("AD"); // Forward, Turn Right

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("3 4 E", mower.getPosition());
    }

    @Test
    void testMoveForwardEast() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.EAST);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("AD"); // Forward, Turn Right

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("4 3 S", mower.getPosition());
    }

    @Test
    void testMoveForwardSouth() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.SOUTH);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("AD"); // Forward, Turn Right

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("3 2 W", mower.getPosition());
    }

    @Test
    void testMoveForwardWest() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.WEST);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("AD"); // Forward, Turn Right

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("2 3 N", mower.getPosition());
    }

    @Test
    void testMoveRight() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("D"); // Turn Right

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("3 3 E", mower.getPosition());
    }

    @Test
    void testMoveLeft() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);
        LawnMowerInstructionList instructions = new LawnMowerInstructionList("G"); // Turn Left

        // Act
        mower.move(lawn, instructions);

        // Assert
        assertEquals("3 3 W", mower.getPosition());
    }

    @Test
    void testNoInstructions() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMower mower = new LawnMower(3, 3, OrientationEnum.NORTH);

        // Act
        mower.move(lawn, null);

        // Assert
        assertEquals("3 3 N", mower.getPosition());
    }


    @Test
    void sanitizeMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), null);
        assertEquals("1 2 N", mower.getPosition());

        mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), new LawnMowerInstructionList(""));
        assertEquals("1 2 N", mower.getPosition());
    }

    @Test
    void testMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), new LawnMowerInstructionList("GAGAGAGAA"));
        assertEquals("1 3 N", mower.getPosition());

        mower = new LawnMower(3, 3, OrientationEnum.EAST);
        mower.move(new Lawn(5, 5), new LawnMowerInstructionList("AADAADADDA"));
        assertEquals("5 1 E", mower.getPosition());
    }

    @Test
    void testGetPosition() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        assertEquals("1 2 N", mower.getPosition());
    }
}
