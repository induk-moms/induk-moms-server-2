package induckmoms.server.club.domain.dto;

import induckmoms.server.club.domain.Club;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClubSaveRequestDTO {
    String name;

    String description;

    String simpleDescription;

    private String problem;

    private Integer answer;

    private String hashtags;

    public Club toEntity(Long userId, Double rating, Long ratingCount){
        return new Club(this.name, this.description, this.simpleDescription,
                rating, ratingCount, userId,
                this.problem, this.answer, this.hashtags);
    }
}
