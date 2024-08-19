package induckmoms.server.ai.claude.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ClaudeRequestContent {
    private String type;
}
