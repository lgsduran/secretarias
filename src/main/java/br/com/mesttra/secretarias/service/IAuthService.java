package br.com.mesttra.secretarias.service;

import org.springframework.http.ResponseEntity;

import br.com.mesttra.secretarias.request.LoginRequest;
import br.com.mesttra.secretarias.request.SignupRequest;

public interface IAuthService {
	
	ResponseEntity<?> authenticateUser(LoginRequest loginRequest);

	ResponseEntity<?> registerUser(SignupRequest signUpRequest);

}
