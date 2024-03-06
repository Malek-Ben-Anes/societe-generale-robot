package com.mowitnow.mower.provider;

import com.mowitnow.mower.provider.Data;
import com.mowitnow.mower.provider.FileDataProvider;
import com.mowitnow.mower.provider.MowerData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileDataProviderTest {

    @Test
    void testLoadData() {
        // Arrange
        FileDataProvider fileDataProvider = new FileDataProvider();

        // Act
        Data data = fileDataProvider.loadData();

        // Assert
        assertNotNull(data);
        assertEquals(5, data.getMaxX());
        assertEquals(5, data.getMaxY());
        assertEquals(2, data.getMowerInputs().size());

        MowerData mower1 = data.getMowerInputs().get(0);
        assertEquals(1, mower1.getX());
        assertEquals(2, mower1.getY());
        assertEquals('N', mower1.getOrientation());
        assertEquals("GAGAGAGAA", mower1.getInstructions());

        MowerData mower2 = data.getMowerInputs().get(1);
        assertEquals(3, mower2.getX());
        assertEquals(3, mower2.getY());
        assertEquals('E', mower2.getOrientation());
        assertEquals("AADAADADDA", mower2.getInstructions());
    }
}
