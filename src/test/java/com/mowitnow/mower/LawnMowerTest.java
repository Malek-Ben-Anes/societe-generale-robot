package com.mowitnow.mower;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructions;
import com.mowitnow.mower.model.OrientationEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    public void testMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH, new LawnMowerInstructions("GAGAGAGAA"));
        mower.move(new Lawn(5, 5));
        assertEquals("1 3 N", mower.getPosition());

        mower = new LawnMower(3, 3, OrientationEnum.EAST, new LawnMowerInstructions("AADAADADDA"));
        mower.move(new Lawn(5, 5));
        assertEquals("5 1 E", mower.getPosition());
    }

    @Test
    public void sanitizeGetPosition() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH, null);
        assertEquals("1 2 N", mower.getPosition());
    }

    @Test
    public void testGetPosition() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH, new LawnMowerInstructions(""));
        assertEquals("1 2 N", mower.getPosition());
    }

}