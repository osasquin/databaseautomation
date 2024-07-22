package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class CommonLamb extends Lamb{
	private static final long serialVersionUID = 2191563910244665645L;
	private boolean registered;

}
