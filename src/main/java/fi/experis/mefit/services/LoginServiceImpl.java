package fi.experis.mefit.services;

import fi.experis.mefit.models.LoginRequest;
import fi.experis.mefit.models.LoginResponse;
import fi.experis.mefit.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ProfileService profileService;

    @Override
    public ResponseEntity<LoginResponse> loginUser(LoginRequest user) {
        try {
            HashMap<String, String> values = new HashMap<>() {{
                put("grant_type", "password");
                put("username", user.getUsername());
                put("password", user.getPassword());
                put("client_id", System.getenv("KEYCLOAK_CLIENT_ID"));
                put("scope", "openid");
            }};

            String form = values.entrySet()
                    .stream()
                    .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            URI uri = new URI(System.getenv("KEYCLOAK_BASE_PATH") + "/realms/mefit/protocol/openid-connect/token");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String[] responseValues = response.body().split("[:,\"]");
            String token = responseValues[4];
            String[] chunks = token.split("\\.");

            Base64.Decoder decoder = Base64.getUrlDecoder();
            String payloadString = new String(decoder.decode(chunks[1]));

            String[] payload = payloadString.split("[,]");
            String[] subject = payload[5].split("[:\"]");
            Profile profile = profileService.getProfileById(subject[4]);

            LoginResponse login = new LoginResponse(profile, token);

            return ResponseEntity
                    .ok()
                    .body(login);

        } catch (RuntimeException | IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }
}