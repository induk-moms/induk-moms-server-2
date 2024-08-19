package induckmoms.server.ai.claude.dto.response;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaudeResponseMessage {
    private List<ClaudeResponseContent> content;
    private String id;
    private String model;
    private String role;
    private Optional<String> stop_reason;
    private Optional<String> stop_sequence;
    private String type;
    private ClaudeUsage usage;
}
