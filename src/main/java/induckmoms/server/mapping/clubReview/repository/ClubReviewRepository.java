package induckmoms.server.mapping.clubReview.repository;

import induckmoms.server.club.domain.Club;
import induckmoms.server.mapping.clubReview.entity.ClubReview;
import induckmoms.server.mapping.clubReview.entity.ClubReviewId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubReviewRepository extends JpaRepository<ClubReview, ClubReviewId> {
    List<ClubReview> findAllByClub(Club club);
}
