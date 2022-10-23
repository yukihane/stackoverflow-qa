package com.example.jaso91693;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping
    public ResponseEntity index(){
        var resp = new ResponseEntity();
        resp.setTestUser(true);
        return resp;
    }
}
