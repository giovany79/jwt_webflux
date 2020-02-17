package co.com.gcode.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

public class Controller {



    @RequestMapping(value = "/resource/user", method = RequestMethod.GET)
    public Mono<ResponseEntity<String>> user(){
        return Mono.just(ResponseEntity.ok("Content for user"));
    }

}
