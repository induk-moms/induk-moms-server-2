package induckmoms.server.mapping.userClub.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserClubId is a Querydsl query type for UserClubId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUserClubId extends BeanPath<UserClubId> {

    private static final long serialVersionUID = -925913987L;

    public static final QUserClubId userClubId = new QUserClubId("userClubId");

    public final NumberPath<Long> clubId = createNumber("clubId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserClubId(String variable) {
        super(UserClubId.class, forVariable(variable));
    }

    public QUserClubId(Path<? extends UserClubId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserClubId(PathMetadata metadata) {
        super(UserClubId.class, metadata);
    }

}

