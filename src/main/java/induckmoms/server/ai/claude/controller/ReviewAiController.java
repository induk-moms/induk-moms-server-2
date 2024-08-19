package induckmoms.server.ai.claude.controller;

import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.service.ClaudeReviewService;
import induckmoms.server.mapping.clubReview.entity.ClubReview;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewAiController {
    private final ClaudeReviewService claudeReviewService;

    @PostMapping("/add/{clubId}/{userId}")
    public ResponseEntity<String> addReview(@PathVariable Long clubId, @PathVariable Long userId, @RequestParam Double starRating, @RequestParam String reviewText) {
        List<ClubReview> clubReviews = claudeReviewService.addReview(clubId, userId, starRating, reviewText);
        ClaudeResponseMessage summarizedReviewResponse = claudeReviewService.getSummarizedReview(clubReviews);
        String summarizedReview = summarizedReviewResponse.getContent().get(0).getText();
        claudeReviewService.updateSimpleDescription(clubId, summarizedReview);
        return new ResponseEntity<>(summarizedReview, HttpStatus.OK);
    }
}
