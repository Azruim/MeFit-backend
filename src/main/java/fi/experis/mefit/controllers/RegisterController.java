package fi.experis.mefit.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<String> registerUser() throws URISyntaxException, IOException, InterruptedException {
        try {
            var values = new HashMap<String, String>() {{
                put ("client_id", "admin-cli");
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


    } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .body("Bad request");
        }

    }
}
