package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.Profile;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileService {
    ResponseEntity<String> addProfile(Profile profile);
    ResponseEntity<Profile> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, Profile profile);
    ResponseEntity<String> deleteProfileById(String profileId);
}
