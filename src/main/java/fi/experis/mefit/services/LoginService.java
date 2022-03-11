package fi.experis.mefit.services;

import fi.experis.mefit.models.User;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<String> loginUser(User user);
}
