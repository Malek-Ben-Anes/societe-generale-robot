package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructionList;
import com.mowitnow.mower.model.enums.InstructionEnum;
import com.mowitnow.mower.model.enums.OrientationEnum;
import com.mowitnow.mower.provider.MowerData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.stream.Collectors;

public class LawnMowerManagerTest {

    @Test
    void testCreateLawnMowerInstruction() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMowerManager manager = new LawnMowerManager(lawn);
        MowerData mowerData = new MowerData(1, 2, 'N', "GAGAGAGAA");

        // Act
        manager.createLawnMowerInstruction(mowerData);
        Map<LawnMower, LawnMowerInstructionList> instructionsMap = manager.getLawnMowersInstructionsMap();

        // Assert
        assertEquals(1, instructionsMap.size());
        assertTrue(instructionsMap.containsKey(new LawnMower(1, 2, OrientationEnum.NORTH)));

        String instructionsString = instructionsMap.get(new LawnMower(1, 2, OrientationEnum.NORTH)).getInstructions().stream()
                .map(InstructionEnum::getValue)
                .map(String::valueOf) // Convert char to String
                .collect(Collectors.joining());
        assertEquals("GAGAGAGAA", instructionsString);
    }

    @Test
    void testRunAllMowers() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMowerManager manager = new LawnMowerManager(lawn);
        manager.createLawnMowerInstruction(new MowerData(1, 2, 'N', "GAGAGAGAA"));
        manager.createLawnMowerInstruction(new MowerData(3, 3, 'E', "AADAADADDA"));

        // Act & Assert
        assertDoesNotThrow(() -> manager.runAllMowers());
    }
}
