package fi.experis.mefit.services;

import com.nimbusds.jose.shaded.json.JSONObject;
import fi.experis.mefit.models.User;
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
            var values = new HashMap<String, String>() {{
                put ("client_id", System.getenv("KEYCLOAK_REGISTER_CLIENT"));
                put("client_secret", System.getenv("KEYCLOAK_CLIENT_SECRET"));
                put("grant_type", "client_credentials");
            }};

            String form = values.entrySet()
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
                    .ok()
                    .body(response.body());


        } catch (RuntimeException | IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body("Bad request");
        }
    }
    //'{"firstName":"Sergey","lastName":"Kargopolov", "email":"test@test.com", "enabled":"true", "username":"app-user"}'


    @Override
    public ResponseEntity<String> registerUser(User user, String tokenResponse) throws URISyntaxException, IOException, InterruptedException {
        try {
            String[] responseValues = tokenResponse.split("[:,\"]");
            String token = responseValues[4];

            HashMap<String, String> values = new HashMap<>() {{
                put ("firstName", user.getFirstName());
                put("lastName", user.getLastName());
                put("username", user.getUserName());
                put("email", user.getEmail());
            }};

            JSONObject body = new JSONObject(values);

            var uri = new URI(System.getenv("KEYCLOAK_BASE_PATH") + "/admin/realms/mefit/users");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .headers("Content-Type", "application/json", "Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return ResponseEntity
                    .ok()
                    .body(response.body());

        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .body(e.toString());
        }
    }
}
