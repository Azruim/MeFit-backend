package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;
import fi.experis.mefit.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }
    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId).get();
    }
    @Override
    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    @Override
    public void updateProfile(Long profileId, Profile profile) {
        // check if the user with the passed id exists or not
        if (profileRepository.findById(profileId).isPresent()) {
            // If user exists then updated
            profileRepository.save(profile);
        }
    }

    @Override
    public void deleteProfileById(Long profileId) {
        try {
            profileRepository.deleteById(profileId);
        }catch(DataAccessException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
