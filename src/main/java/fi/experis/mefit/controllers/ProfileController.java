package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.services.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/profiles")
@SecurityRequirement(name = "keycloak_implicit")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Optional<Profile>> getProfileById(@PathVariable String profileId) {
        return profileService.getProfileById(profileId);
    }

    @PostMapping("")
    public Profile addProfile(@RequestBody Profile profile) {
        return profileService.addProfile(profile);
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<String> updateProfile(@PathVariable String profileId, @RequestBody Profile profile) {
        try {
            profileService.updateProfile(profileId, profile);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String profileId) {
        try {
            profileService.deleteProfileById(profileId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(RuntimeException e){
            // log the error message
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
