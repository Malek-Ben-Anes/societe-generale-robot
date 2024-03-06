package com.mowitnow.mower.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LawnTest {

    @Test
    public void testValidLawn() {
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
    public void testNegativeWidth() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(-5, 5));
    }

    @Test
    public void testNegativeHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(5, -5));
    }

    @Test
    public void testZeroWidthAndHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(0, 0));
    }

    @Test
    public void testZeroWidth() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(0, 5));
    }

    @Test
    public void testZeroHeight() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new Lawn(5, 0));
    }
}
