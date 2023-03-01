package com.aetios.projetospringmongo.config;

import com.aetios.projetospringmongo.domain.User;
import com.aetios.projetospringmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user1 = new User(null, "Usuario 1", "usuario_1@gmail.com");
        User user2 = new User(null, "Usuario 2", "usuario_2@gmail.com");
        User user3 = new User(null, "Usuario 3", "usuario_3@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
