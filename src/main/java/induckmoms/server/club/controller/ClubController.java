package induckmoms.server.club.controller;

import induckmoms.server.club.api.controller.dto.response.ClubReviewResponse;
import induckmoms.server.club.domain.Club;
import induckmoms.server.club.service.ClubService;
import induckmoms.server.common.BaseResponse;
import induckmoms.server.common.code.status.ErrorStatus;
import induckmoms.server.common.exceptions.BaseException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@Slf4j
public class ClubController {
    private final ClubService clubService;

    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    @Operation(summary = "모든 동아리 조회 API", description = "모든 동아리를 조회합니다.")
    public BaseResponse<List<Club>> getAllClubs(){
        List<Club> clubs = clubService.findAllClub();
        if(clubs.isEmpty())
            throw new BaseException(ErrorStatus.CLUB_NO_CONTENTS_ERROR);// BaseResponse.onFailure("404", "동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(clubs);
    }

    @GetMapping("/clubs/{clubId}")
    @Operation(summary = "특정 동아리 조회 API", description = "특정 동아리를 조회합니다.")
    public BaseResponse<Club> getAllClubs(@PathVariable(name = "clubId") Long clubId){
        Club findClub = clubService.findById(clubId);
        if(findClub == null) return BaseResponse.onFailure("404", "해당 동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(findClub);
    }

    @GetMapping("/{clubId}/quizs")
    @Operation(summary = "퀴즈 조회 API", description = "퀴즈를 조회합니다.")
    public BaseResponse<String> getQuiz(@PathVariable(name = "clubId") Long clubId){
        String findQuiz = clubService.findQuiz(clubId);
        if(findQuiz == null) return BaseResponse.onFailure("404", "동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(findQuiz);
    }

    @PostMapping("/{clubId}/quizs")
    @Operation(summary = "퀴즈 풀기 API", description = "퀴즈를 풉니다.")
    public BaseResponse<Boolean> solveQuiz(@PathVariable(name = "clubId") Long clubId, @RequestBody SolveQuiz answer){
        Boolean correctness = clubService.solveQuiz(clubId, answer.getAnswer());
        if(correctness == null) return BaseResponse.onFailure("400", "틀렸습니다.", false);
        else return BaseResponse.onSuccess(true);
    }

    @GetMapping("/{clubId}/reviews")
    @Operation(summary = "리뷰 조회 API", description = "리뷰를 조회합니다.")
    public BaseResponse<List<ClubReviewResponse>> getReviews(@PathVariable(name = "clubId") Long clubId){
        List<ClubReviewResponse> reviews = clubService.findReviews(clubId);
        if(reviews.isEmpty()) return BaseResponse.onFailure("404", "리뷰가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(reviews);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class SolveQuiz{
        Integer answer;
    }



}
