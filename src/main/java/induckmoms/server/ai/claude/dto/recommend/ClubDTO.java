package induckmoms.server.ai.claude.dto.recommend;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubDTO {
    private Long id;
    private Double rating;
    private List<String> tags;
}
