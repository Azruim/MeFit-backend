package fi.experis.mefit.controllers;

import fi.experis.mefit.models.dtos.profileDtos.get.ProfileGetDTO;
import fi.experis.mefit.models.dtos.profileDtos.post.CreateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.patch.UpdateProfileDTO;
import fi.experis.mefit.services.interfaces.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Get profile by id")
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileGetDTO> getProfileById(@Parameter(description = "Id of profile to be searched") @PathVariable String profileId) {
        return profileService.getProfileById(profileId);
    }

    @Operation(summary = "Create a new profile")
    @PostMapping
    public ResponseEntity<String> addProfile(@RequestBody CreateProfileDTO profile) {
        return profileService.addProfile(profile);
    }

    @Operation(summary = "Update profile by id")
    @PatchMapping("/{profileId}")
    public ResponseEntity<String> updateProfile(@Parameter(description = "Id of profile to be updated") @PathVariable String profileId, @RequestBody UpdateProfileDTO profile) {
        return profileService.updateProfile(profileId, profile);
    }

    @Operation(summary = "Delete profile by id")
    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@Parameter(description = "Id of profile to be deleted") @PathVariable String profileId) {
        return profileService.deleteProfileById(profileId);
    }
}
