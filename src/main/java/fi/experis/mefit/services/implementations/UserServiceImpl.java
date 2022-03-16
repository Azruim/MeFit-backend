package fi.experis.mefit.services.implementations;

import com.nimbusds.jose.shaded.json.JSONObject;
import fi.experis.mefit.models.User;
import fi.experis.mefit.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {}

    @Value("#{systemEnvironment['KEYCLOAK_BASE_PATH']}")
    String basePath;

    public ResponseEntity<Object> updateUser(User user, String token) {

        JSONObject json = new JSONObject();
        json.put("firstName", user.getFirstName());
        json.put("lastName", user.getLastName());
        json.put("email", user.getEmail());

        try {
            URI uri = new URI(basePath + "/realms/mefit/account/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type","application/json")
                    .header("Accept", "application/json")
                    .header("Authorization", token)
                    .POST(HttpRequest.BodyPublishers.ofString(json.toJSONString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 401)
                return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
        catch (URISyntaxException | InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }
}