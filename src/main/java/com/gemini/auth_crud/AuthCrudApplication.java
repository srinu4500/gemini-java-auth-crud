package com.gemini.auth_crud;

import com.gemini.auth_crud.entity.User;
import com.gemini.auth_crud.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                userRepository.save(admin);
                System.out.println("Default admin user created: admin/admin");
            }
        };
    }
}
