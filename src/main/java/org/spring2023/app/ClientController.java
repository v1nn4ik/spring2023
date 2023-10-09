package org.spring2023.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientConfig clientConfig;

    @GetMapping(value = "/employee")
    public String client() {
        return String.format("Employee:\n %s\n username: %s\n number: %d", clientConfig.name, clientConfig.username, clientConfig.number);
    }
}
