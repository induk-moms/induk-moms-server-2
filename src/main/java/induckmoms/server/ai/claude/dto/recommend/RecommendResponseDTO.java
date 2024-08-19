package induckmoms.server.ai.claude.dto.recommend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendResponseDTO {
    private Long clubId;
    private String clubName;
    private Double starRating;
    private int clubUserCount;
    private String hashTags;
    private String result;
}
