package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.profileDtos.CreateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.UpdateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.GetProfileDTO;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<String> addProfile(CreateProfileDTO profile);
    ResponseEntity<GetProfileDTO> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, UpdateProfileDTO profile);
    ResponseEntity<String> deleteProfileById(String profileId);
}
