package induckmoms.server.mapping.clubReview.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClubReview is a Querydsl query type for ClubReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClubReview extends EntityPathBase<ClubReview> {

    private static final long serialVersionUID = -1404136804L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClubReview clubReview = new QClubReview("clubReview");

    public final induckmoms.server.club.domain.QClub club;

    public final StringPath content = createString("content");

    public final QClubReviewId id;

    public final NumberPath<Double> rating = createNumber("rating", Double.class);

    public final induckmoms.server.user.domain.QUser user;

    public QClubReview(String variable) {
        this(ClubReview.class, forVariable(variable), INITS);
    }

    public QClubReview(Path<? extends ClubReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClubReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClubReview(PathMetadata metadata, PathInits inits) {
        this(ClubReview.class, metadata, inits);
    }

    public QClubReview(Class<? extends ClubReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new induckmoms.server.club.domain.QClub(forProperty("club")) : null;
        this.id = inits.isInitialized("id") ? new QClubReviewId(forProperty("id")) : null;
        this.user = inits.isInitialized("user") ? new induckmoms.server.user.domain.QUser(forProperty("user")) : null;
    }

}

