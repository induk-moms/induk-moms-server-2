package induckmoms.server.club.controller;

import induckmoms.server.club.domain.Club;
import induckmoms.server.club.service.ClubService;
import induckmoms.server.common.BaseResponse;
import induckmoms.server.common.code.status.ErrorStatus;
import induckmoms.server.common.exceptions.BaseException;
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
    public BaseResponse<List<Club>> getAllClubs(){
        List<Club> clubs = clubService.findAllClub();
        if(clubs.isEmpty())
            throw new BaseException(ErrorStatus.CLUB_NO_CONTENTS_ERROR);// BaseResponse.onFailure("404", "동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(clubs);
    }

    @GetMapping("/clubs/{clubId}")
    public BaseResponse<Club> getAllClubs(@PathVariable(name = "clubId") Long clubId){
        Club findClub = clubService.findById(clubId);
        if(findClub == null) return BaseResponse.onFailure("404", "해당 동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(findClub);
    }

    @GetMapping("/clubs/{clubId}/quizs")
    public BaseResponse<String> getQuiz(@PathVariable(name = "clubId") Long clubId){
        String findQuiz = clubService.findQuiz(clubId);
        if(findQuiz == null) return BaseResponse.onFailure("404", "동아리가 존재하지 않습니다.", null);
        else return BaseResponse.onSuccess(findQuiz);
    }

    @PostMapping("api/{clubId}/quizs")
    public BaseResponse<Boolean> solveQuiz(@PathVariable(name = "clubId") Long clubId, @RequestBody Integer answer){
        Boolean correctness = clubService.solveQuiz(clubId, answer);
        if(correctness == null) return BaseResponse.onFailure("400", "틀렸습니다.", false);
        else return BaseResponse.onSuccess(true);
    }


}
