package induckmoms.server.ai.claude.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ClaudeMessage {
    private String role;
}
