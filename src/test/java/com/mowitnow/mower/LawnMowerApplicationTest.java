package com.mowitnow.mower;

import com.mowitnow.mower.provider.FileDataProvider;
import com.mowitnow.mower.provider.MockDataProvider;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LawnMowerApplicationTest {

    @Test
    public void testExecuteLawnMowerProgramFromFile() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.executeLawnMowerProgram(new FileDataProvider().loadData());
        var expected = "----------- Print final result ----------- 1 3 N 5 1 E".replaceAll("[\\r\\n\\s]", "");
        var result = outContent.toString().replaceAll("[\\r\\n\\s]", "");
        assertEquals(expected, result);
    }

    @Test
    void testExecuteLawnMowerProgramFromMockData() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LawnMowerApplication.executeLawnMowerProgram(new MockDataProvider().loadData());
        var expected = "----------- Print final result ----------- 1 3 N 5 1 E".replaceAll("[\\r\\n\\s]", "");
        var result = outContent.toString().replaceAll("[\\r\\n\\s]", "");
        assertEquals(expected, result);
    }

}