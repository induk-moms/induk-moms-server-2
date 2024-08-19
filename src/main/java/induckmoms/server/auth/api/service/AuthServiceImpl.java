package induckmoms.server.auth.api.service;

import induckmoms.server.auth.api.controller.dto.request.LoginRequest;
import induckmoms.server.auth.api.controller.dto.response.LoginResponse;
import induckmoms.server.auth.api.mapper.AuthMapper;
import induckmoms.server.common.exceptions.BaseException;
import induckmoms.server.user.domain.User;
import induckmoms.server.user.domain.repository.UserJpaRepository;
import induckmoms.server.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static induckmoms.server.common.BaseEntity.State.ACTIVE;
import static induckmoms.server.common.code.status.ErrorStatus.FAILED_TO_LOGIN;
import static induckmoms.server.common.code.status.ErrorStatus.NOT_FIND_USER;


/**
 * AuthServiceImpl은 인증 관련 비즈니스 로직을 처리하는 서비스 클래스.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final UserJpaRepository userJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;
    private final JwtProvider jwtProvider;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User findUser = userJpaRepository.findByEmailAndState(loginRequest.email(), ACTIVE)
                .orElseThrow(() -> new BaseException(NOT_FIND_USER));
        try{
            authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        } catch (BadCredentialsException e) {
            throw new BaseException(FAILED_TO_LOGIN);
        }
        String accessToken = jwtProvider.generateToken(findUser);
        return authMapper.userToLoginResponse(findUser, accessToken);
    }
}

