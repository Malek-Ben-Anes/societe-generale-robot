package com.mowitnow.mower.model;

/**
 * Record representing the lawn dimensions
 */
public record Lawn(int width, int height) {

    // Constructor with validation for non-negative dimensions
    public Lawn {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be non-negative");
        }
    }
}
