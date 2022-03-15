package fi.experis.mefit.services;

import fi.experis.mefit.models.RegisterUser;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface RegisterService {
    ResponseEntity<Object> registerUser(RegisterUser user) throws URISyntaxException, IOException, InterruptedException;
}
