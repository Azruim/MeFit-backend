package fi.experis.mefit.controllers;

import fi.experis.mefit.models.User;
import fi.experis.mefit.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("")
    public ResponseEntity<String> getAccessToken() {
        return registerService.getAccessToken();
    }

    @PostMapping("")
    public User registerUser(@RequestBody User user, @RequestHeader Jwt token) {
        return registerService.registerUser(user, token);
    }

}
