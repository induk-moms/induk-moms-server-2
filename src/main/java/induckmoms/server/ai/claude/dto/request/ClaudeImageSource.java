package induckmoms.server.ai.claude.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClaudeImageSource {
    private String type;
    private String media_type;
    private String data;
}
