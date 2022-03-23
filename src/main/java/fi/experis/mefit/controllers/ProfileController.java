package fi.experis.mefit.controllers;

import fi.experis.mefit.models.dtos.ProfileDTO;
import fi.experis.mefit.models.entities.Profile;
import fi.experis.mefit.services.interfaces.ProfileService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/profiles")
@SecurityRequirement(name = "keycloak_implicit")
@PreAuthorize("hasAnyRole('ROLE_regular-user', 'ROLE_contributor', 'ROLE_admin')")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> getProfileById(@PathVariable String profileId) {
        return profileService.getProfileById(profileId);
    }

    @PostMapping
    public ResponseEntity<String> addProfile(@RequestBody ProfileDTO profile) {
        return profileService.addProfile(profile);
    }

    @PatchMapping("/{profileId}")
    public ResponseEntity<String> updateProfile(@PathVariable String profileId, @RequestBody ProfileDTO profile) {
        return profileService.updateProfile(profileId, profile);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String profileId) {
        return profileService.deleteProfileById(profileId);
    }
}
