package induckmoms.server.club.service;

import induckmoms.server.club.api.controller.dto.response.ClubReviewResponse;
import induckmoms.server.club.domain.Club;
import induckmoms.server.club.domain.dto.ClubSaveRequestDTO;
import induckmoms.server.club.domain.respository.ClubJpaRepository;
import induckmoms.server.mapping.clubReview.entity.ClubReview;
import induckmoms.server.mapping.clubReview.repository.ClubReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {
    private final ClubJpaRepository clubRepository;
    private final ClubReviewRepository clubReviewRepository;


    public void saveClub(ClubSaveRequestDTO clubSaveRequestDTO, Long userId) {
        clubRepository.save(clubSaveRequestDTO.toEntity(userId, 0.0, 0L));
    }

    public Club findByName(String clubName){
        return clubRepository.findClubByName(clubName).orElseGet(null);
    }

    public Club findById(Long clubId){
        return clubRepository.findById(clubId).orElseGet(null);
    }

    public List<Club> findAllClub(){
        return clubRepository.findALLByOrderByStarRatingDesc();
    }

    public void updateRating(String clubName, Double rating){
        Club findClub = clubRepository.findClubByName(clubName).orElseGet(null);

        Long ratingCount = findClub.getRatingCount();
        ratingCount++;

        if(ratingCount == 1L){
            findClub.setRatingCount(ratingCount);
            findClub.setStarRating(rating);
        }
        else {
            Double findRating = findClub.getStarRating();
            findRating = findRating * (ratingCount - 1);
            findClub.setStarRating((findRating + rating) / ratingCount);
            findClub.setRatingCount(ratingCount);
        }
        clubRepository.save(findClub);
    }

    public String findQuiz(Long clubId){
        Club findClub = clubRepository.findById(clubId).orElseGet(null);
        if(findClub == null) return null;
        else return findClub.getProblem();
    }

    public Boolean solveQuiz(Long clubId, Integer answer){
        Club findClub = clubRepository.findById(clubId).orElseGet(null);
        if(findClub == null) return null;
        else return !findClub.getAnswer().equals(answer);
    }

    public List<ClubReviewResponse> findReviews(Long clubId) {
        Club club = clubRepository.findById(clubId).orElseGet(null);
        if(club == null) return null;

        return clubReviewRepository.findAllByClub(club)
                .stream()
                .map(ClubReviewResponse::new)
                .toList();
    }
}
