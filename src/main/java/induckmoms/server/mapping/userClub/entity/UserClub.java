package induckmoms.server.mapping.userClub.entity;

import induckmoms.server.club.domain.Club;
import induckmoms.server.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Builder
@Entity
@Table(name = "user_club_tb")
public class UserClub {

    @EmbeddedId
    private UserClubId id;

    @MapsId("clubId")
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private LocalDateTime registrationDate;
}
