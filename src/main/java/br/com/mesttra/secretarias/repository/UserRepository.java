package br.com.mesttra.secretarias.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.secretarias.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);	

	Boolean existsByUsername(String username);

}