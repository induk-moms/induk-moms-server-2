package induckmoms.server.ai.claude.controller;

import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.service.ClaudeRecommendService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recommend")
@RequiredArgsConstructor
public class ClaudeRecommendController {
    private final ClaudeRecommendService claudeRecommendService;

    @GetMapping("/clubs")
    @Operation(summary = "해시태그 추천 동아리 조회 API", description = "해시태그를 기반으로 추천 동아리를 조회합니다.")
    public ResponseEntity<?> recommendClubByHashTags(@RequestParam String hashTags) {
        ClaudeResponseMessage claudeResponseMessage = claudeRecommendService.extractRecommendedClubs(hashTags);
        String jsonResponse = claudeResponseMessage.getContent().get(0).getText();
        return new ResponseEntity<>(claudeRecommendService.getRecommendClubInformation(jsonResponse), HttpStatus.OK);
    }
}
