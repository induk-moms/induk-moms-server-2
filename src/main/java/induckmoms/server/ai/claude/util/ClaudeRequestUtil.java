package induckmoms.server.ai.claude.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import induckmoms.server.ai.claude.dto.recommend.ClubDTO;
import induckmoms.server.ai.claude.dto.request.ClaudeMessage;
import induckmoms.server.ai.claude.dto.request.ClaudeRequestMessage;
import induckmoms.server.ai.claude.dto.request.ClaudeTextMessage;
import induckmoms.server.club.domain.Club;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@RequiredArgsConstructor
public class ClaudeRequestUtil {
    @Value("${claude.model}")
    private String model;
    @Value("${claude.max.tokens}")
    private Integer maxTokens;
    @Value("${claude.recommend.system}")
    private String recommendSystem;
    @Value("${claude.summarize.system}")
    private String summarizeSystem;

    private ClaudeRequestMessage createCommonClaudeRequest(String systemRole, List<ClaudeMessage> messages) {
        return ClaudeRequestMessage.builder()
                .model(model)
                .max_tokens(maxTokens)
                .system(systemRole)
                .messages(messages)
                .build();
    }

    private String makeClubsToJson(List<Club> clubs) {
        try{
            List<ClubDTO> clubDTOs = clubs.stream()
                    .map(ClubMapper::toDto)
                    .toList();

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(clubDTOs);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert clubs to JSON", e);
        }
    }

    public ClaudeRequestMessage createClubRecommendRequest(List<Club> clubs, String userHashTags) {
        String clubsDTOJson = makeClubsToJson(clubs);
        String request = "지금 존재하는 동아리들은 \n" + clubsDTOJson + "\n그리고 유저가 동아리에서 원하는 해시태그 들은 " + userHashTags + "야. 이 중에서 동아리 5개를 추천해줘!";
        request+="그리고 반환하는 답변은\n"
                + "\n"
                + "[\n"
                + "  {\n"
                + "    \"id\": \"clubId\",\n"
                + "    \"result\": \"친절한 설명\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": \"clubId\",\n"
                + "    \"result\": \"친절한 설명\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": \"clubId\",\n"
                + "    \"result\": \"친절한 설명\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": \"clubId\",\n"
                + "    \"result\": \"친절한 설명\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"id\": \"clubId\",\n"
                + "    \"result\": \"친절한 설명\"\n"
                + "  }\n"
                + "]"
                + "\n"
                + "\n"
                + "이것과 같이 JSON 형태를 딱 맞춰서 반환해줬으면 좋겠어! 만약 5개 미만이면 개수가 있는 것 만큼만 반환해줘!";
        List<ClaudeMessage> messages = List.of(new ClaudeTextMessage("user", request));
        return createCommonClaudeRequest(recommendSystem, messages);
    }

    public ClaudeRequestMessage createSummarizeRequest(String allReviews) {
        List<ClaudeMessage> messages = List.of(new ClaudeTextMessage("user", allReviews));
        return createCommonClaudeRequest(summarizeSystem, messages);
    }
}
