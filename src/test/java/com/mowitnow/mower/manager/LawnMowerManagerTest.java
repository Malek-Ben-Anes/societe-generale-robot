package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;
import com.mowitnow.mower.model.LawnMowerInstructionList;
import com.mowitnow.mower.model.enums.InstructionEnum;
import com.mowitnow.mower.model.enums.OrientationEnum;
import com.mowitnow.mower.provider.MowerInputData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
import java.util.stream.Collectors;

class LawnMowerManagerTest {

    @Test
    void testCreateLawnMowerInstruction() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        LawnMowerManager manager = new LawnMowerManager(lawn);
        MowerInputData mowerInputData = new MowerInputData(1, 2, 'N', "GAGAGAGAA");

        // Act
        manager.createLawnMowerInstruction(mowerInputData);
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
        manager.createLawnMowerInstruction(new MowerInputData(1, 2, 'N', "GAGAGAGAA"));
        manager.createLawnMowerInstruction(new MowerInputData(3, 3, 'E', "AADAADADDA"));

        // Act & Assert
        assertDoesNotThrow(() -> manager.runAllMowers());
    }
}
