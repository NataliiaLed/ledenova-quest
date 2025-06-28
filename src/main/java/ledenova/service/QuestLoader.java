package ledenova.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import ledenova.model.QuestNode;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestLoader {
    public static final String QUESTS_PATH = "quests/";
    public static final String ELARA_QUEST_ID = "elara-quest";

    public static Map<String, QuestNode> loadQuestNodesFromYaml(String questId) {
        String resourcePath = QUESTS_PATH + questId + ".yaml";
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // Load resource as InputStream from classpath
        try (InputStream is = QuestLoader.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalArgumentException("Quest file not found: " + resourcePath);
            }
            List<QuestNode> nodes = mapper.readValue(is,
                    mapper.getTypeFactory().constructCollectionType(List.class, QuestNode.class));
            return nodes.stream()
                    .collect(Collectors.toMap(QuestNode::getId, node -> node));
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load quest " + resourcePath);
        }
    }
}
