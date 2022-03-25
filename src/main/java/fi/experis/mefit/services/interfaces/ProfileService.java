package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.profileDtos.post.CreateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.patch.UpdateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.get.ProfileGetDTO;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<String> addProfile(CreateProfileDTO profile);
    ResponseEntity<ProfileGetDTO> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, UpdateProfileDTO profile);
    ResponseEntity<String> deleteProfileById(String profileId);
}
