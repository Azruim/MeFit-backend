package fi.experis.mefit.controllers;

import fi.experis.mefit.models.RegisterUser;
import fi.experis.mefit.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUser user) throws URISyntaxException, IOException, InterruptedException {
        return registerService.registerUser(user, registerService.getAccessToken().getBody());

    }

}
