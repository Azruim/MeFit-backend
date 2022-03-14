package fi.experis.mefit.services;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import fi.experis.mefit.models.RegisterUser;
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
import java.util.stream.Collectors;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Override
    public ResponseEntity<String> getAccessToken() {
        try {
            HashMap<String, String> requestData = new HashMap<>() {{
                put("client_id", System.getenv("KEYCLOAK_REGISTER_CLIENT"));
                put("client_secret", System.getenv("KEYCLOAK_CLIENT_SECRET"));
                put("grant_type", "client_credentials");
            }};

            String form = requestData.entrySet()
                    .stream()
                    .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            var uri = new URI(System.getenv("KEYCLOAK_BASE_PATH") + "/realms/master/protocol/openid-connect/token");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(form))
                    .build();


            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return ResponseEntity
                    .status(response.statusCode())
                    .body(response.body());


        } catch (RuntimeException | IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body("Bad request");
        }
    }

    @Override
    public ResponseEntity<String> registerUser(RegisterUser user, String tokenResponse) throws URISyntaxException, IOException, InterruptedException {
        try {
            URI registerUri = new URI(System.getenv("KEYCLOAK_BASE_PATH") + "/admin/realms/mefit/users");

            String[] responseValues = tokenResponse.split("[\"]");
            String token = responseValues[3];
            JSONArray credentials = user.getCredentials();

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


            return ResponseEntity
                    .status(response.statusCode())
                    .body(response.body());

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(e.toString());
        }
    }
}
