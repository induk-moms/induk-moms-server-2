package induckmoms.server.mapping.userClub.repository;

import induckmoms.server.mapping.userClub.entity.UserClub;
import induckmoms.server.mapping.userClub.entity.UserClubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClubRepository extends JpaRepository<UserClub, UserClubId> {
}
