package com.example.demo.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository repository){
        return args -> {
            User sean = new User(
                    "current",
                    new BigDecimal("10.75"),
                    "kembosean@gmail.com",
                    new BCryptPasswordEncoder().encode("kembosean7"),

                    "Sean",
                    "Kembo"
            );
            User alex = new User(

                    "savings",
                    new BigDecimal("00.0"),
                    "alexander@gmail.com",
                    new BCryptPasswordEncoder().encode("alexagu@22"),
                    "Alexander",
                    "Agu"
            );
            repository.saveAll(List.of(sean, alex));

        };
    }

}
