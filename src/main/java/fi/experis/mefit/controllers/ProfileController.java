package fi.experis.mefit.controllers;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.services.interfaces.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Profile> getProfileById(@PathVariable String profileId) {
        return profileService.getProfileById(profileId);
    }

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        return profileService.addProfile(profile);
    }

    @PatchMapping("/{profileId}")
    public ResponseEntity<Profile> updateProfile(@PathVariable String profileId, @RequestBody Profile profile) {
        return profileService.updateProfile(profileId, profile);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String profileId) {
        return profileService.deleteProfileById(profileId);
    }
}
