package fi.experis.mefit.controllers;

import fi.experis.mefit.models.User;
import fi.experis.mefit.services.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user, @RequestHeader("Authorization") String token) {
        return userService.updateUser(user, token);
    }
}
