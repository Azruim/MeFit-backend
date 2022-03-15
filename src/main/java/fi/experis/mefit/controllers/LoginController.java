package fi.experis.mefit.controllers;

import fi.experis.mefit.models.LoginRequest;
import fi.experis.mefit.models.LoginResponse;
import fi.experis.mefit.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest user) {
        return loginService.loginUser(user);
    }
}
