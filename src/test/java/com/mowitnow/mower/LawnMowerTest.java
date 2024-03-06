package com.mowitnow.mower;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructions;
import com.mowitnow.mower.model.OrientationEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    public void sanitizeMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), null);
        assertEquals("1 2 N", mower.getPosition());

        mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), new LawnMowerInstructions(""));
        assertEquals("1 2 N", mower.getPosition());
    }

    @Test
    public void testMove() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        mower.move(new Lawn(5, 5), new LawnMowerInstructions("GAGAGAGAA"));
        assertEquals("1 3 N", mower.getPosition());

        mower = new LawnMower(3, 3, OrientationEnum.EAST);
        mower.move(new Lawn(5, 5), new LawnMowerInstructions("AADAADADDA"));
        assertEquals("5 1 E", mower.getPosition());
    }

    @Test
    public void testGetPosition() {
        LawnMower mower = new LawnMower(1, 2, OrientationEnum.NORTH);
        assertEquals("1 2 N", mower.getPosition());
    }

}