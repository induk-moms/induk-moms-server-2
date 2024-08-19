package induckmoms.server.ai.claude.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaudeRequestMessage {
    private String model;
    private Integer max_tokens;
    private String system = "you are very kind";
    private List<ClaudeMessage> messages;
    private boolean stream;
}
