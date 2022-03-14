package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }
    @Override
    public ResponseEntity<Optional<Profile>> getProfileById(String profileId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(profileRepository.findById(profileId));
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
    public void updateProfile(String profileId, Profile profile) {
        // check if the user with the passed id exists or not
        if (profileRepository.findById(profileId).isPresent()) {
            // If user exists then updated
            profileRepository.save(profile);
        }
    }

    @Override
    public void deleteProfileById(String profileId) {
        try {
            profileRepository.deleteById(profileId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
