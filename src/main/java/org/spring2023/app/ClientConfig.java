package org.spring2023.app;

import org.spring2023.domain.Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Value("${client.name}")
    String name;
    @Value("${client.username}")
    String username;
    @Value("${client.number}")
    int number;
    @Bean
    public Client myClient() {
        return new Client(name, username, number);
    }
}
