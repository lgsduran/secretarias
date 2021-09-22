package br.com.mesttra.secretarias.request;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;

import br.com.mesttra.secretarias.entity.Secretarias;
import br.com.mesttra.secretarias.enums.Folder;
import lombok.Data;

@Data
public class SecretaryRequest {

	@NotEmpty
	private String secretaryName;
	
	private Folder folder;

	private int populationGrade;

	private boolean underInvestigation;

	public Secretarias toEntity() {
		Secretarias secretarias = new Secretarias();
		BeanUtils.copyProperties(this, secretarias);
		return secretarias;
	}

}
