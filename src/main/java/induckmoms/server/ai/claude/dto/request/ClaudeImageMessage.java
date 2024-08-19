package induckmoms.server.ai.claude.dto.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClaudeImageMessage extends ClaudeMessage{
    List<ClaudeRequestContent> content;

    public ClaudeImageMessage(String role, List<ClaudeRequestContent> content) {
        super(role);
        this.content = content;
    }
}
