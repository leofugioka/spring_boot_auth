package com.springauth.springauthproject.config;

import com.springauth.springauthproject.entities.User;
import com.springauth.springauthproject.repositories.UserRepository;
import com.springauth.springauthproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.UUID;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        // Registering Users
        userService.create("Clara Rodrigues", "clara_rodrigues@teste.com", "4asd8w");
        userService.create("Roberto Farias", "roberto@email.com", "123456");
        userService.create("Humberto Doisberto", "12berto@blablabla.com", "@4t!=-asA");
    }
}
