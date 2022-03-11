package fi.experis.mefit.services;

import fi.experis.mefit.models.LoginResponse;
import fi.experis.mefit.models.User;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<LoginResponse> loginUser(User user);
}
