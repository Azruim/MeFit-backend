package fi.experis.mefit.models;

import java.util.Optional;

public class LoginResponse {
    private Optional<Profile> profile;
    private String token;

    public LoginResponse(Optional<Profile> profile, String token) {
        this.profile = profile;
        this.token = token;
    }

    public Optional<Profile> getProfile() {
        return profile;
    }

    public void setProfile(Optional<Profile> profile) {
        this.profile = profile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
