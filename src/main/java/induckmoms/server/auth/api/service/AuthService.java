package induckmoms.server.auth.api.service;


import induckmoms.server.auth.api.controller.dto.request.LoginRequest;
import induckmoms.server.auth.api.controller.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
