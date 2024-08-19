package induckmoms.server.mapping.clubReview.entity;

import induckmoms.server.club.domain.Club;
import induckmoms.server.user.domain.User;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Builder
@Entity
@Table(name = "club_review_tb")
public class ClubReview {

    @EmbeddedId
    private ClubReviewId id;

    @MapsId("clubId")
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double rating;
    private String content;

    public String getContents() {
        return content;
    }
}
