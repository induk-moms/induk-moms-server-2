package induckmoms.server.club.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
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
    private Double startRating;

    @NotNull
    private Long ratingCount;

    @NotNull
    private Long userId;

    @NotNull
    private String hashtags;
}
