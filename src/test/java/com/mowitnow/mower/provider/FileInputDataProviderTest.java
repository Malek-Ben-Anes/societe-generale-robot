package com.mowitnow.mower.provider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileInputDataProviderTest {

    @Test
    void testLoadData() {
        // Arrange
        FileDataProvider fileDataProvider = new FileDataProvider();

        // Act
        InputData inputData = fileDataProvider.loadData();

        // Assert
        assertNotNull(inputData);
        assertEquals(5, inputData.maxX());
        assertEquals(5, inputData.maxY());
        assertEquals(2, inputData.mowerInputs().size());

        MowerInputData mower1 = inputData.mowerInputs().get(0);
        assertEquals(1, mower1.x());
        assertEquals(2, mower1.y());
        assertEquals('N', mower1.orientation());
        assertEquals("GAGAGAGAA", mower1.instructions());

        MowerInputData mower2 = inputData.mowerInputs().get(1);
        assertEquals(3, mower2.x());
        assertEquals(3, mower2.y());
        assertEquals('E', mower2.orientation());
        assertEquals("AADAADADDA", mower2.instructions());
    }
}
