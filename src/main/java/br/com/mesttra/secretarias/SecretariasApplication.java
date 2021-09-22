package br.com.mesttra.secretarias;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mesttra.secretarias.request.SignupRequest;
import br.com.mesttra.secretarias.service.AuthServiceImpl;

@SpringBootApplication
public class SecretariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretariasApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(AuthServiceImpl authService) {
		return args -> {
			authService.registerUser(new SignupRequest("teste", "teste", Arrays.asList("ADMIN")));
		};		
	}

}
