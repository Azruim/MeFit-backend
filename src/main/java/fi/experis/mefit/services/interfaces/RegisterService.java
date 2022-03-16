package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RegisterService {
    ResponseEntity<Object> registerUser(User user) throws URISyntaxException, IOException, InterruptedException;
}
