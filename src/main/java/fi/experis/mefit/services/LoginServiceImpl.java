package fi.experis.mefit.services;

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
import java.util.Base64;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public ResponseEntity<String> loginUser(User user) {
        System.out.println(user.getPassword());
        try {
            HashMap<String, String> values = new HashMap<>() {{
                put("grant_type", "password");
                put("username", "test");
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
            System.out.println(token);

            Base64.Decoder decoder = Base64.getUrlDecoder();

            String[] chunks = token.split("\\.");

            String payloadString = new String(decoder.decode(chunks[1]));

            String[] payload = payloadString.split("[,]");
//            for (String entry:payload) {
//                System.out.println(entry);
//            }
            System.out.println(payload[4]);
            System.out.println(payload[11]);
            System.out.println(payload[13]);
            System.out.println(payload[14]);
            System.out.println(payload[15]);

            return ResponseEntity
                    .ok()
                    .body(token);

        } catch (RuntimeException | IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body("Bad request");
        }
    }
}