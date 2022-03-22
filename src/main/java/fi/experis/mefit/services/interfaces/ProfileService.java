package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.entities.Profile;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProfileService {
    ResponseEntity<String> addProfile(Profile profile);
    ResponseEntity<Profile> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, Map<Object, Object> fields);
    ResponseEntity<String> deleteProfileById(String profileId);
}
