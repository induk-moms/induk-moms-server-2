package induckmoms.server.ai.claude.service;

import induckmoms.server.ai.claude.dto.request.ClaudeRequestMessage;
import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.util.ClaudeRequestUtil;
import induckmoms.server.club.domain.Club;
import induckmoms.server.club.domain.respository.ClubJpaRepository;
import java.util.List;
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
}
