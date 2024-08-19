package induckmoms.server.ai.claude.controller;

import induckmoms.server.ai.claude.dto.response.ClaudeResponseMessage;
import induckmoms.server.ai.claude.service.ClaudeRecommendService;
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
    public ResponseEntity<?> recommendClubByHashTags(@RequestParam String hashTags) {
        ClaudeResponseMessage claudeResponseMessage = claudeRecommendService.extractRecommendedClubs(hashTags);
        String jsonResponse = claudeResponseMessage.getContent().get(0).getText();
        return new ResponseEntity<>(claudeRecommendService.getRecommendClubInformation(jsonResponse), HttpStatus.OK);
    }
}
