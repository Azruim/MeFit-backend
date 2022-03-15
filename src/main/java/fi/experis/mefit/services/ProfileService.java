package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileService {
    ResponseEntity<Profile> addProfile(Profile profile);
    ResponseEntity<Profile> getProfileById(String profile);
    ResponseEntity<Profile> updateProfile(String profileId, Profile profile);
    ResponseEntity<String> deleteProfileById(String profileId);
    ResponseEntity<List<Profile>> getAllProfiles();
}
