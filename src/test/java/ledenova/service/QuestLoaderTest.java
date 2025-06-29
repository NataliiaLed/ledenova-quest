package ledenova.service;

import ledenova.model.QuestNode;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestLoaderTest {

    @Test
    void loadQuestNodesFromYaml_validQuest_returnsMap() {
        Map<String, QuestNode> nodes = QuestLoader.loadQuestNodesFromYaml("elara-quest");
        assertNotNull(nodes);
        assertFalse(nodes.isEmpty());

        assertTrue(nodes.containsKey("start"));

        QuestNode startNode = nodes.get("start");
        assertNotNull(startNode.getText());
        assertNotNull(startNode.getDecisionOptions());
    }

    @Test
    void loadQuestNodesFromYaml_missingFile_throwsIllegalArgumentException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> QuestLoader.loadQuestNodesFromYaml("non-existent-quest"));
        assertTrue(ex.getMessage().contains("Quest file not found"));
    }

    @Test
    void loadQuestNodesFromYaml_invalidYaml_throwsRuntimeException() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> QuestLoader.loadQuestNodesFromYaml("invalid-quest"));
        assertTrue(ex.getMessage().contains("Failed to load quest"));
    }
}
