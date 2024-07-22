package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class SacrificialLamb extends Lamb{
	private static final long serialVersionUID = 4336609838753713072L;
	
	private boolean registered;
	@ManyToOne
	private Levite levite;
	
	public String sacrifice() {
		return "this Lamb is a SacrificialLamb but it can not be categorized";
	}
}
