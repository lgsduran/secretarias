package br.com.mesttra.secretarias.service;

import static java.lang.String.format;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mesttra.secretarias.entity.Secretarias;
import br.com.mesttra.secretarias.exception.BusinessException;
import br.com.mesttra.secretarias.repository.SecretariasRepository;
import br.com.mesttra.secretarias.request.SecretaryRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Log4j2
@Service
public class SecretariasServiceImpl implements ISecretariasService {

	SecretariasRepository secretariasRepository;

	@Override
	public Secretarias addSecretary(SecretaryRequest secretary) throws BusinessException {
		if (secretariasRepository.existsBySecretaryName(secretary.getSecretaryName())) {
			log.info("Secretary name already exists.");
			if (secretariasRepository.existsByFolder(secretary.getFolder())) {
				throw new BusinessException(format("Folder %s already taken.", secretary.getFolder()));
			}
		}

		log.info("Secretary added successfully.");
		return this.secretariasRepository.save(secretary.toEntity());
	}

	@Override
	public Page<Secretarias> listSecretaries(Pageable pageable) {
		return this.secretariasRepository.findAll(pageable);
	}

	@Override
	public Secretarias getSecretaryById(long id) throws BusinessException {
		return this.secretariasRepository.findById(id)
				.orElseThrow(() -> new BusinessException(format("Id %s not found.", id)));
	}

	@Override
	public Secretarias underInvestigation(long id, Boolean isUnderInvestigation) throws BusinessException {
		Secretarias db = this.secretariasRepository.findById(id)
				.orElseThrow(() -> new BusinessException(format("Id %s not found.", id)));
		log.info("Boolean successfully changed.");
		db.setUnderInvestigation(isUnderInvestigation);
		return this.secretariasRepository.save(db);
	}

}
