package ledenova.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
public class Decision {
    private String id;
    private String decision;
    private String questItemId;
}
