package fi.experis.mefit.services.interfaces;

import fi.experis.mefit.models.dtos.profileDtos.post.CreateProfileDTO;
import fi.experis.mefit.models.dtos.profileDtos.patch.UpdateProfileDTO;
import fi.experis.mefit.models.entities.Profile;
import fi.experis.mefit.models.dtos.getDtos.ProfileGetDTO;
import fi.experis.mefit.models.dtos.postDtos.CreateProfileDTO;
import fi.experis.mefit.models.dtos.postDtos.UpdateProfileDTO;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    ResponseEntity<String> addProfile(CreateProfileDTO profile);
    ResponseEntity<Profile> getProfileById(String profile);
    ResponseEntity<String> updateProfile(String profileId, UpdateProfileDTO profile);
    ResponseEntity<String> deleteProfileById(String profileId);
}
