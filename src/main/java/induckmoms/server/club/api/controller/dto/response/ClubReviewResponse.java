package induckmoms.server.club.api.controller.dto.response;


import induckmoms.server.mapping.clubReview.entity.ClubReview;

public record ClubReviewResponse(
        String contents, // 'contnets' 오타를 'contents'로 수정
        Double rating,
        String term
) {
    public ClubReviewResponse(ClubReview clubReview) {
        this(clubReview.getContents(), clubReview.getRating(), "24-1학기 동아리원");
    }
}