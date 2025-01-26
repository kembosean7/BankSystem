package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository){
        return args -> {
            User sean = new User(
                    "current",
                    00.0,
                    "kembosean@gmail.com",
                    "Sean"
            );
            User alex = new User(

                    "savings",
                    00.0,
                    "alexander@gmail.com",
                    "Alex"
            );
            repository.saveAll(List.of(sean, alex));

        };
    }

}
