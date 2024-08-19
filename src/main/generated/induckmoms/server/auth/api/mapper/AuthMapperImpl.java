package induckmoms.server.auth.api.mapper;

import induckmoms.server.auth.api.controller.dto.response.LoginResponse;
import induckmoms.server.user.domain.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-20T00:04:56+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Azul Systems, Inc.)"
)
@Component
public class AuthMapperImpl implements AuthMapper {

    @Override
    public LoginResponse userToLoginResponse(User user, String accessToken) {
        if ( user == null && accessToken == null ) {
            return null;
        }

        Long userId = null;
        if ( user != null ) {
            userId = user.getId();
        }
        String accessToken1 = null;
        accessToken1 = accessToken;

        LoginResponse loginResponse = new LoginResponse( userId, accessToken1 );

        return loginResponse;
    }
}
