package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.repositories.ProfileRepository;
import fi.experis.mefit.services.interfaces.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ResponseEntity<String> addProfile(Profile profile) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("/api/v1/profiles/" + profileRepository.save(profile).getProfileId());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Profile> getProfileById(String profileId) {
        try {
            if (profileRepository.findById(profileId).isPresent()) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(profileRepository.findById(profileId).get());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateProfile(String profileId, Profile profile) {
        try {
            if (profileRepository.existsById(profileId)) {
                profile.setProfileId(profileId);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/profiles/" + profileRepository.save(profile).getProfileId());
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> deleteProfileById(String profileId) {
        try {
            profileRepository.deleteById(profileId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
