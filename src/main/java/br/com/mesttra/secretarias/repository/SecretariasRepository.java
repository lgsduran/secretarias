package br.com.mesttra.secretarias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mesttra.secretarias.entity.Secretarias;
import br.com.mesttra.secretarias.enums.Folder;

public interface SecretariasRepository extends JpaRepository<Secretarias, Long> {

	Boolean existsBySecretaryName(String secretary);
	
	Boolean existsByFolder(Folder folder);

}
