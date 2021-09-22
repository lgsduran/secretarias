package br.com.mesttra.secretarias.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.mesttra.secretarias.enums.Folder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@Entity
@Table(	name = "secretarias", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "folder")
})
public class Secretarias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "secretaria_id")
	private long id;
	
	@Column(name = "secretary_name")
	private String secretaryName;
	
	@Enumerated(EnumType.STRING)
	private Folder folder;
	
	@Column(name = "population_grade")
	private int populationGrade;
	
	@Column(name = "under_investigation")
	private boolean underInvestigation;

}
