package ledenova.model;

import lombok.Data;

import java.util.List;

@Data
public class QuestNode {
    private String id;
    private String text;
    private QuestNodeType type;
    private List<Decision> decisionOptions;

}
