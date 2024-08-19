package induckmoms.server.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1689767349L;

    public static final QUser user = new QUser("user");

    public final induckmoms.server.common.QBaseEntity _super = new induckmoms.server.common.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> blockedAt = createDateTime("blockedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath pw = createString("pw");

    public final EnumPath<induckmoms.server.user.domain.enums.Role> role = createEnum("role", induckmoms.server.user.domain.enums.Role.class);

    //inherited
    public final EnumPath<induckmoms.server.common.BaseEntity.State> state = _super.state;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

