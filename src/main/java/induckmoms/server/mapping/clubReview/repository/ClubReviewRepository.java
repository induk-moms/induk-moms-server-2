package induckmoms.server.mapping.clubReview.repository;

import induckmoms.server.mapping.clubReview.entity.ClubReview;
import induckmoms.server.mapping.clubReview.entity.ClubReviewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubReviewRepository extends JpaRepository<ClubReview, ClubReviewId> {
}
