package fi.experis.mefit.services;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import fi.experis.mefit.models.Profile;
import fi.experis.mefit.models.RegisterUser;
import fi.experis.mefit.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Value("#{systemEnvironment['KEYCLOAK_REGISTER_CLIENT']}")
    String registerClient;

    @Value("#{systemEnvironment['KEYCLOAK_REGISTER_CLIENT_SECRET']}")
    String registerSecret;

    @Value("#{systemEnvironment['KEYCLOAK_BASE_PATH']}")
    String basePath;

    private final ProfileRepository profileRepository;

    public RegisterServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public String getAccessToken() {
        try {
            HashMap<String, String> requestData = new HashMap<>() {{
                put("client_id", registerClient);
                put("client_secret", registerSecret);
                put("grant_type", "client_credentials");
            }};

            String form = requestData.entrySet()
                    .stream()
                    .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            var uri = new URI(basePath + "/realms/master/protocol/openid-connect/token");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .build();


            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return response.body();


        } catch (RuntimeException | IOException | InterruptedException | URISyntaxException e) {
            return e.getMessage();
        }
    }

    @Override
    public ResponseEntity<Object> registerUser(RegisterUser user) throws URISyntaxException, IOException, InterruptedException {
        try {
            URI registerUri = new URI(basePath + "/admin/realms/mefit/users");

            String accessToken = getAccessToken();

            String[] responseValues = accessToken.split("[\"]");
            String token = responseValues[3];
            JSONObject credObj = new JSONObject() {{
                put("type" , "password");
                put("value", user.getPassword());
                put("temporary", false);
            }};

            JSONArray credentials = new JSONArray() {{
                appendElement(credObj);
            }};

            JSONObject userBody = new JSONObject();
            userBody.put("firstName", user.getFirstName());
            userBody.put("lastName", user.getLastName());
            userBody.put("username", user.getUsername());
            userBody.put("email", user.getEmail());
            userBody.put("enabled", "true");
            userBody.put("credentials", credentials);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(registerUri)
                    .headers("Content-Type", "application/json", "Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofString(userBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                Map<String, List<String>> headers = response.headers().map();
                String[] userId = headers.get("location").get(0).split("users/");

                Profile newProfile = new Profile();
                newProfile.setProfileId(userId[1]);

                profileRepository.save(newProfile);

                return ResponseEntity
                        .status(response.statusCode())
                        .body(userId[1]);
            } else {
                return ResponseEntity
                        .status(response.statusCode())
                        .body(response.body());
            }

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(e.toString());
        }
    }
}
