package fi.experis.mefit.services;

import fi.experis.mefit.models.RegisterUser;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RegisterService {
    ResponseEntity<String> getAccessToken();
    ResponseEntity<String> registerUser(RegisterUser user, String token) throws URISyntaxException, IOException, InterruptedException;
}
