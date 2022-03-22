package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.entities.Profile;
import fi.experis.mefit.repositories.ProfileRepository;
import fi.experis.mefit.services.interfaces.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<String> updateProfile(String profileId, Map<Object, Object> fields) {
        try {
            Optional<Profile> profile = profileRepository.findById(profileId);
            if (profile.isPresent()) {
                fields.forEach((Object key, Object value) -> {
                    System.out.println();
                    Field field = ReflectionUtils.findField(Profile.class, (String) key);
                    assert field != null;
                    field.trySetAccessible();
                    ReflectionUtils.setField(field, profile.get(), value);
                });
                Profile updatedProfile = profileRepository.save(profile.get());
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("/api/v1/profiles/" + updatedProfile.getProfileId());
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
