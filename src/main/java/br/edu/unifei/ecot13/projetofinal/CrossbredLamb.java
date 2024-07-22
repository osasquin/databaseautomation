package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class CrossbredLamb extends Lamb{
	private static final long serialVersionUID = 5099117171618356588L;
	private String fatherBreed;
	private String motherBreed;
	
}
