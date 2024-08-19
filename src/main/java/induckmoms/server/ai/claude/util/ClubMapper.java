package induckmoms.server.ai.claude.util;

import induckmoms.server.ai.claude.dto.recommend.ClubDTO;
import induckmoms.server.club.domain.Club;
import java.util.Arrays;
import java.util.List;

public class ClubMapper {
    public static ClubDTO toDto(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setId(club.getId());
        dto.setRating(club.getStarRating());
        List<String> tags = Arrays.stream(club.getHashtags().split("\\s+"))  // 공백으로 분리
                .filter(s -> s.startsWith("#"))  // '#'으로 시작하는 것만 필터링
                .toList();
        dto.setTags(tags);
        return dto;
    }
}
