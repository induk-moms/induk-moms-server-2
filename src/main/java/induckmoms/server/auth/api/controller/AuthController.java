package induckmoms.server.auth.api.controller;

import induckmoms.server.auth.api.controller.dto.request.LoginRequest;
import induckmoms.server.auth.api.controller.dto.response.LoginResponse;
import induckmoms.server.auth.api.service.AuthService;
import induckmoms.server.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static induckmoms.server.common.code.status.SuccessStatus.LOGIN_OK;


/**
 * AuthController는 인증 관련 엔드포인트를 처리.
 */
@Slf4j
@Tag(name = "auth controller", description = "인증 필요 없는 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    /**
     * 서버 상태 확인 API
     *
     * <p>서버의 상태를 확인.</p>
     *
     * @return 서버 상태 메시지를 포함하는 BaseResponse<String>
     */
    @GetMapping("/health")
    @Operation(summary = "서버 상태 확인 API",description = "서버 상태를 확인합니다.")
    public BaseResponse<String> health() {
        return BaseResponse.onSuccess("I'm healthy");
    }



    @PostMapping("/login")
    @Operation(summary = "로그인 API",description = "로그인을 처리합니다.")
    public BaseResponse<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return BaseResponse.of(LOGIN_OK, authService.login(loginRequest));
    }







}
