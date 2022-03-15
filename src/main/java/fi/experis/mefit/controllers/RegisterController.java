package fi.experis.mefit.controllers;

import fi.experis.mefit.models.RegisterUser;
import fi.experis.mefit.services.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/register")
@CrossOrigin("*")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody RegisterUser user) throws URISyntaxException, IOException, InterruptedException {
        return registerService.registerUser(user);
    }

}
