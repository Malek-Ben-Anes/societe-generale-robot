package com.mowitnow.mower.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void testValidLawn() {
        // Arrange
        int width = 5;
        int height = 5;

        // Act
        Lawn lawn = new Lawn(width, height);

        // Assert
        assertEquals(width, lawn.width());
        assertEquals(height, lawn.height());
    }

    @Test
    void testNegativeWidth() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(-5, 5));
    }

    @Test
    void testNegativeHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(5, -5));
    }

    @Test
    void testZeroWidthAndHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(0, 0));
    }

    @Test
    void testZeroWidth() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(0, 5));
    }

    @Test
    void testZeroHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(5, 0));
    }
}
