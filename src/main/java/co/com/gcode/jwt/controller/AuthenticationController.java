package co.com.gcode.jwt.controller;


import co.com.gcode.jwt.config.JwtUtil;
import co.com.gcode.jwt.config.PBKDF2PasswordEncoder;
import co.com.gcode.jwt.config.UserService;
import co.com.gcode.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PBKDF2PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Mono<ResponseEntity<?>> login(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername()).map((userDetails) -> {
            System.out.println("Pass:" + passwordEncoder.encode(user.getPassword()));
            System.out.println("Pass2:" + userDetails.getPassword());
            if (passwordEncoder.encode(user.getPassword()).equals(userDetails.getPassword())) {
                return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
            } else {
                System.out.println("No coinciden las claves");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}

