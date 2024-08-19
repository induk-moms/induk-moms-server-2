package induckmoms.server.ai.claude.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClaudeTextContent extends ClaudeRequestContent {
    private String text;

    public ClaudeTextContent(String type, String text) {
        super(type);
        this.text = text;
    }
}
