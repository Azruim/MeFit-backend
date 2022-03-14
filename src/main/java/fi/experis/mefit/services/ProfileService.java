package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    Profile addProfile(Profile profile);
    ResponseEntity<Optional<Profile>> getProfileById(String profile);
    void updateProfile(String profileId, Profile profile);
    void deleteProfileById(String profileId);
    ResponseEntity<List<Profile>> getAllProfiles();
}
