package br.com.mesttra.secretarias.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mesttra.secretarias.entity.Secretarias;
import br.com.mesttra.secretarias.exception.BusinessException;
import br.com.mesttra.secretarias.request.SecretaryRequest;

public interface ISecretariasService {

	Secretarias addSecretary(SecretaryRequest secretary) throws BusinessException;

	Page<Secretarias> listSecretaries(Pageable pageable);

	Secretarias getSecretaryById(long id) throws BusinessException;

	Secretarias underInvestigation(long id, Boolean isUnderInvestigation) throws BusinessException;

}
