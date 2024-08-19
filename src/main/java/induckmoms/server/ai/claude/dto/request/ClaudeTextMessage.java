package induckmoms.server.ai.claude.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClaudeTextMessage extends ClaudeMessage {
    private String content;

    public ClaudeTextMessage(String role, String content) {
        super(role);
        this.content = content;
    }
}
