package induckmoms.server.ai.claude.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClaudeResponseContent {
    private String text;
    private String type;
}
