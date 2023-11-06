package org.spring2023.extern.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from API");
    }
}
