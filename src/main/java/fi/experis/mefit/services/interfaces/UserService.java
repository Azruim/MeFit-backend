package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> updateUser(User user, String token);
}
