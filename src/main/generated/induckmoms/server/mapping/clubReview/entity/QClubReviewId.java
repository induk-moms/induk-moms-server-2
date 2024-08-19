package induckmoms.server.mapping.clubReview.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClubReviewId is a Querydsl query type for ClubReviewId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QClubReviewId extends BeanPath<ClubReviewId> {

    private static final long serialVersionUID = -755735337L;

    public static final QClubReviewId clubReviewId = new QClubReviewId("clubReviewId");

    public final NumberPath<Long> clubId = createNumber("clubId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QClubReviewId(String variable) {
        super(ClubReviewId.class, forVariable(variable));
    }

    public QClubReviewId(Path<? extends ClubReviewId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClubReviewId(PathMetadata metadata) {
        super(ClubReviewId.class, metadata);
    }

}

