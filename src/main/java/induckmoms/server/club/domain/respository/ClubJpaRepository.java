package induckmoms.server.club.domain.respository;

import induckmoms.server.club.domain.Club;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubJpaRepository extends JpaRepository<Club, Long> {
    Optional<Club> findClubByName(String Name);
    List<Club> findALLByOrderByStarRatingDesc();
}
