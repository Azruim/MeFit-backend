package fi.experis.mefit.models;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;

import java.util.HashMap;

public class RegisterUser {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private boolean enabled;

    private JSONArray credentials = new JSONArray();

    public RegisterUser() {
        super();
    }

    public RegisterUser(String firstName, String lastName, String username, String email, boolean enabled, JSONArray credentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.credentials = credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public JSONArray getCredentials() {
        return credentials;
    }

    public void setCredentials(JSONArray credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", credentials=" + credentials +
                '}';
    }
}