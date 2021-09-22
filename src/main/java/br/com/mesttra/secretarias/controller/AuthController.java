package br.com.mesttra.secretarias.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.secretarias.request.LoginRequest;
import br.com.mesttra.secretarias.request.SignupRequest;
import br.com.mesttra.secretarias.service.AuthServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/secretarias/auth/")
public class AuthController {

	private AuthServiceImpl authService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return this.authService.authenticateUser(loginRequest);

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		return this.authService.registerUser(signUpRequest);

	}

}