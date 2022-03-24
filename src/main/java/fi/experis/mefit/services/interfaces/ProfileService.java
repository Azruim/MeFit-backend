package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.postDtos.ProfileDTO;
import fi.experis.mefit.models.entities.Profile;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<String> addProfile(ProfileDTO profile);
    ResponseEntity<Profile> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, ProfileDTO profile);
    ResponseEntity<String> deleteProfileById(String profileId);
}
