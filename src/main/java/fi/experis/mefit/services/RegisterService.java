package fi.experis.mefit.services;

import fi.experis.mefit.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;

public interface RegisterService {
    ResponseEntity<String> getAccessToken();
    User registerUser(User user, Jwt token);
}
