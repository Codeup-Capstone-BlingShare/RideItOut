package com.capstone.rideitout.seeder;

import com.capstone.rideitout.Model.Users;
import com.capstone.rideitout.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class usersSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public usersSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Create and save sample users
        Users user1 = new Users("user1@example.com", "John", "Doe", passwordEncoder.encode("password1"), "johndoe");
        Users user2 = new Users("user2@example.com", "Jane", "Smith", passwordEncoder.encode("password2"), "janesmith");

        // Save users to the database
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
