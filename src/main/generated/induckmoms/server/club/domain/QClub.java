package induckmoms.server.club.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QClub is a Querydsl query type for Club
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClub extends EntityPathBase<Club> {

    private static final long serialVersionUID = 1226454795L;

    public static final QClub club = new QClub("club");

    public final NumberPath<Integer> answer = createNumber("answer", Integer.class);

    public final StringPath description = createString("description");

    public final StringPath hashtags = createString("hashtags");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath problem = createString("problem");

    public final NumberPath<Long> ratingCount = createNumber("ratingCount", Long.class);

    public final StringPath simpleDescription = createString("simpleDescription");

    public final NumberPath<Double> starRating = createNumber("starRating", Double.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QClub(String variable) {
        super(Club.class, forVariable(variable));
    }

    public QClub(Path<? extends Club> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClub(PathMetadata metadata) {
        super(Club.class, metadata);
    }

}

