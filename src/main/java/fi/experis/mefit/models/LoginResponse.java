package fi.experis.mefit.models;

public class LoginResponse {
    private Profile profile;
    private String token;

    public LoginResponse(Profile profile, String token) {
        this.profile = profile;
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
