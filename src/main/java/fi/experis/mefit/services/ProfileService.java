package fi.experis.mefit.services;

import fi.experis.mefit.models.Profile;

import java.util.List;

public interface ProfileService {
    Profile addProfile(Profile profile);
    Profile getProfileById(String profile);
    void updateProfile(String profileId, Profile profile);
    void deleteProfileById(String profileId);
    List<Profile> getAllProfiles();
}
