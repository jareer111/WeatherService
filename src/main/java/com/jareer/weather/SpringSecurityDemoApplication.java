package com.jareer.weather;

import com.jareer.weather.entity.User;
import com.jareer.weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.TimeZone;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringSecurityDemoApplication {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);

    }
/*
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			User user = new User();
			user.setEmail("string@mail.uz");

			user.setPassword(passwordEncoder.encode("string"));
			userRepository.save(user);
		};
	}*/
}
