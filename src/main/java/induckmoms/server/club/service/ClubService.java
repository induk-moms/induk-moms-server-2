package induckmoms.server.club.service;

import induckmoms.server.club.domain.Club;
import induckmoms.server.club.domain.dto.ClubSaveRequestDTO;
import induckmoms.server.club.domain.respository.ClubJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubJpaRepository clubRepository;

    public ClubService(ClubJpaRepository clubRepository){
        this.clubRepository = clubRepository;
    }

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
        return clubRepository.findAll();
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
}
