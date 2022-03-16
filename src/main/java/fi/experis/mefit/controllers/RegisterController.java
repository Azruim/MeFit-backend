package fi.experis.mefit.controllers;

import fi.experis.mefit.models.User;
import fi.experis.mefit.services.interfaces.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<Object> registerUser(@RequestBody User user) throws URISyntaxException, IOException, InterruptedException {
        return registerService.registerUser(user);
    }

}
