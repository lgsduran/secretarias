package br.com.mesttra.secretarias.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.secretarias.entity.Secretarias;
import br.com.mesttra.secretarias.exception.BusinessException;
import br.com.mesttra.secretarias.request.SecretaryRequest;
import br.com.mesttra.secretarias.service.SecretariasServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/secretarias")
public class SecretariasController {

	SecretariasServiceImpl secretariasService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Secretarias addSecretarias(@Valid @RequestBody SecretaryRequest secretary) throws BusinessException {
		return this.secretariasService.addSecretary(secretary);
	}
	
	@GetMapping
	public Page<Secretarias> listSecretarias(@Valid  @PageableDefault Pageable pageable) {
		return this.secretariasService.listSecretaries(pageable);
	}
	
	@GetMapping("/{id}")
	public Secretarias getSecretaryById(@Valid  @PathVariable long id) throws BusinessException {
		return this.secretariasService.getSecretaryById(id);
	}
	
	@PatchMapping("/{id}/investigation")
	public Secretarias underInvestigation(@Valid @PathVariable long id, @RequestBody Boolean isUnderInvestigation) throws BusinessException {
		return this.secretariasService.underInvestigation(id, isUnderInvestigation);
		
	}

}
