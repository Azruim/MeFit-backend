package fi.experis.mefit.services;

import fi.experis.mefit.models.LoginRequest;
import fi.experis.mefit.models.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<LoginResponse> loginUser(LoginRequest user);
}
