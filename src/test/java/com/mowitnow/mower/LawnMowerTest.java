package com.mowitnow.mower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    public void testMove() {
        LawnMower mower = new LawnMower(1, 2, 'N');
        mower.move("GAGAGAGAA", 5, 5);
        assertEquals("1 3 N", mower.getPosition());

        mower = new LawnMower(3, 3, 'E');
        mower.move("AADAADADDA", 5, 5);
        assertEquals("5 1 E", mower.getPosition());
    }

    @Test
    public void testGetPosition() {
        LawnMower mower = new LawnMower(1, 2, 'N');
        assertEquals("1 2 N", mower.getPosition());
    }

}