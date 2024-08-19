package induckmoms.server.ai.claude.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaudeUsage {
    private Integer input_tokens;
    private Integer output_tokens;
}
