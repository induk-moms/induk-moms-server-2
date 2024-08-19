package induckmoms.server.ai.claude.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import induckmoms.server.ai.claude.dto.recommend.RecommendResponseDTO;
import induckmoms.server.ai.claude.dto.request.ClaudeRequestMessage;
import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.util.ClaudeRequestUtil;
import induckmoms.server.club.domain.Club;
import induckmoms.server.club.domain.respository.ClubJpaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ClaudeRecommendService {
    private final ClubJpaRepository clubJpaRepository;
    private final ClaudeRequestUtil claudeRequestUtil;
    private final RestClient claudeRestClient;

    private ClaudeResponseMessage sendRequest(ClaudeRequestMessage request) {
        return claudeRestClient.post()
                .body(request)
                .retrieve()
                .body(ClaudeResponseMessage.class);
    }

    public ClaudeResponseMessage extractRecommendedClubs(String userHashTags) {
        //TODO: 동아리 리포에서 findAll, Claude API로 hashTags 인자들과 같이 보내서 추천 동아리 5개 뽑아달라고 하기
        List<Club> clubs = clubJpaRepository.findAll();
        ClaudeRequestMessage requestMessage = claudeRequestUtil.createClubRecommendRequest(clubs, userHashTags);
        return sendRequest(requestMessage);
    }

    public List<RecommendResponseDTO> getRecommendClubInformation(String jsonResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> recommendations;
        try {
            recommendations = objectMapper.readValue(jsonResponse, new TypeReference<List<Map<String, Object>>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON response", e);
        }

        // RecommendResponseDTO 리스트 생성
        List<RecommendResponseDTO> responseDTOs = new ArrayList<>();
        for (Map<String, Object> recommendation : recommendations) {
            Long clubId = Long.valueOf(recommendation.get("id").toString());
            String result = (String) recommendation.get("result");

            Club club = clubJpaRepository.findById(clubId).orElse(null); // clubRepository는 의존성 주입이 필요합니다

            if (club != null) {
                RecommendResponseDTO dto = RecommendResponseDTO.builder()
                        .clubId(clubId)
                        .clubName(club.getName())
                        .starRating(club.getStarRating())
                        .clubUserCount(club.getRatingCount().intValue())
                        .hashTags(club.getHashtags())
                        .result(result)
                        .build();

                responseDTOs.add(dto);
            }
        }
        return responseDTOs;
    }
}
