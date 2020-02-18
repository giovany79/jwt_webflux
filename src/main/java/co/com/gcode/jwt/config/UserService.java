package co.com.gcode.jwt.config;

import co.com.gcode.jwt.Role;
import co.com.gcode.jwt.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
public class UserService {


    private final String userUsername = "user";
    private final User user = new User(userUsername, "/e8PWHSmy6KwBk2Z6VQb3Urn5ll6b6Cj43HScoKgaWg=", true, Arrays.asList(Role.ROLE_USER));


    public Mono<User> findByUsername(String username) {
        if (username.equals(userUsername)) {
            return Mono.just(user);
        } else {
            return Mono.empty();
        }
    }

}
