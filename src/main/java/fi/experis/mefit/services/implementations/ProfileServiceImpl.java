package fi.experis.mefit.services.implementations;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.repositories.ProfileRepository;
import fi.experis.mefit.services.interfaces.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ResponseEntity<Profile> addProfile(Profile profile) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(profileRepository.save(profile));
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
    public ResponseEntity<List<Profile>> getAllProfiles(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(profileRepository.findAll());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Profile> updateProfile(String profileId, Profile profile) {
        try {
            if (profileRepository.existsById(profileId)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(profileRepository.save(profile));
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
