package induckmoms.server.ai.claude.service;

import induckmoms.server.ai.claude.dto.request.ClaudeRequestMessage;
import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.util.ClaudeRequestUtil;
import induckmoms.server.club.domain.Club;
import induckmoms.server.club.domain.respository.ClubJpaRepository;
import induckmoms.server.mapping.clubReview.entity.ClubReview;
import induckmoms.server.mapping.clubReview.entity.ClubReviewId;
import induckmoms.server.mapping.clubReview.repository.ClubReviewRepository;
import induckmoms.server.user.domain.User;
import induckmoms.server.user.domain.repository.UserJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ClaudeReviewService {
    private final ClubJpaRepository clubJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final ClubReviewRepository clubReviewRepository;
    private final ClaudeRequestUtil claudeRequestUtil;
    private final RestClient claudeRestClient;

    private ClaudeResponseMessage sendRequest(ClaudeRequestMessage request) {
        return claudeRestClient.post()
                .body(request)
                .retrieve()
                .body(ClaudeResponseMessage.class);
    }

    public List<ClubReview> addReview(Long clubId, Long userId, Double starRating, String review) {
        //TODO: 리뷰 추가하고, 이 추가된 리뷰를 바탕으로 AI에 리뷰 요약 시키기 -> 바뀐 리뷰 요약을 통해 리뷰 테이블 업데이트
        Club club = clubJpaRepository.findById(clubId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동아리입니다."));
        User user = userJpaRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        ClubReview clubReview = new ClubReview(new ClubReviewId(clubId, userId), club, user, starRating, review);
        clubReviewRepository.save(clubReview);
        return clubReviewRepository.findAllByClub(club);
    }

    public ClaudeResponseMessage getSummarizedReview(List<ClubReview> reviews) {
        StringBuilder allReviews = new StringBuilder();

        reviews.stream()
                .map(ClubReview::getContent)
                .forEach(review -> allReviews.append(review).append(" "));

        ClaudeRequestMessage requestMessage = claudeRequestUtil.createSummarizeRequest(allReviews.toString());
        return sendRequest(requestMessage);
    }

    public void updateSimpleDescription(Long clubId, String simpleDescription) {
        Club club = clubJpaRepository.findById(clubId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동아리입니다."));
        club.setSimpleDescription(simpleDescription);
        clubJpaRepository.save(club);
    }
}
