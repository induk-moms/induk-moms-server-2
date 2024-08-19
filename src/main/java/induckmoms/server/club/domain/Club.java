package induckmoms.server.club.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Builder
@Entity
@Table(name = "club_tb")
public class Club {

    @Id
    @Column(name = "club_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private String simpleDescription;

    @NotNull
    private Double starRating;

    @NotNull
    private Long ratingCount;

    @NotNull
    private Long userId;

    @NotNull
    private String problem;

    @NotNull
    private Integer answer;

    @NotNull
    private String hashtags;

    public Club(String name, String description, String simpleDescription, Double starRating, Long ratingCount, Long userId, String problem, Integer answer, String hashtags) {
        this.name = name;
        this.description = description;
        this.simpleDescription = simpleDescription;
        this.starRating = starRating;
        this.ratingCount = ratingCount;
        this.userId = userId;
        this.problem = problem;
        this.answer = answer;
        this.hashtags = hashtags;
    }
}
