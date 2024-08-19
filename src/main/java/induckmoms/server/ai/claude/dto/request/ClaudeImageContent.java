package induckmoms.server.ai.claude.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClaudeImageContent extends ClaudeRequestContent {
    private ClaudeImageSource source;

    public ClaudeImageContent(String type, ClaudeImageSource source) {
        super(type);
        this.source = source;
    }
}
