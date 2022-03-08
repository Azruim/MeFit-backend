package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile getProfileById(Long profile);
    void updateProfile(Long profileId, Profile profile);
    void deleteProfileById(Long profileId);
    List<Profile> getAllProfiles();
}
