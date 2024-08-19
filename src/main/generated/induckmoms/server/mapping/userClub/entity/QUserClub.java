package induckmoms.server.mapping.userClub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserClub is a Querydsl query type for UserClub
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserClub extends EntityPathBase<UserClub> {

    private static final long serialVersionUID = -1685877822L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserClub userClub = new QUserClub("userClub");

    public final induckmoms.server.club.domain.QClub club;

    public final QUserClubId id;

    public final DateTimePath<java.time.LocalDateTime> registrationDate = createDateTime("registrationDate", java.time.LocalDateTime.class);

    public final induckmoms.server.user.domain.QUser user;

    public QUserClub(String variable) {
        this(UserClub.class, forVariable(variable), INITS);
    }

    public QUserClub(Path<? extends UserClub> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserClub(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserClub(PathMetadata metadata, PathInits inits) {
        this(UserClub.class, metadata, inits);
    }

    public QUserClub(Class<? extends UserClub> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new induckmoms.server.club.domain.QClub(forProperty("club")) : null;
        this.id = inits.isInitialized("id") ? new QUserClubId(forProperty("id")) : null;
        this.user = inits.isInitialized("user") ? new induckmoms.server.user.domain.QUser(forProperty("user")) : null;
    }

}

