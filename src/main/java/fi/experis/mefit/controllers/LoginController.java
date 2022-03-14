package fi.experis.mefit.controllers;

import fi.experis.mefit.models.LoginRequest;
import fi.experis.mefit.models.LoginResponse;
import fi.experis.mefit.models.User;
import fi.experis.mefit.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest user) {
        return loginService.loginUser(user);
    }
}
