package br.com.mesttra.secretarias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.secretarias.entity.Role;
import br.com.mesttra.secretarias.enums.ERole;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole name);

}
