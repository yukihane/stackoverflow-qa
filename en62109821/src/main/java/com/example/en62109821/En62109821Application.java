package com.example.en62109821;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class En62109821Application {

    public static void main(final String[] args) {
        SpringApplication.run(En62109821Application.class, args);
    }

    // http://localhost:8080/30
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserInfoDTO> getUserById(@PathVariable final Long id) {
        return new ResponseEntity<>(new UserInfoDTO("by id: " + id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> getUserByUsername(@RequestParam(required = false) final String username) {
        if (username != null) {
            // http://localhost:8080/?username=myname
            return new ResponseEntity<>(new UserInfoDTO("by username: " + username), HttpStatus.OK);
        } else {
            // http://localhost:8080/
            return getAllUsers();
        }
    }

    private ResponseEntity<List<UserInfoDTO>> getAllUsers() {
        return new ResponseEntity<>(List.of(new UserInfoDTO("user1-of-all"), new UserInfoDTO("user2-of-all")),
            HttpStatus.OK);
    }
}
