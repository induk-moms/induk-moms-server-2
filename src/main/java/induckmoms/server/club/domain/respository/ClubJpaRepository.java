package induckmoms.server.club.domain.respository;


import induckmoms.server.club.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubJpaRepository extends JpaRepository<Club, Long> {

    Optional<Club> findClubByName(String Name);
}
