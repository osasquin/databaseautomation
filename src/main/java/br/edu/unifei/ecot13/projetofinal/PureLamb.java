package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class PureLamb extends SacrificialLamb{
	private static final long serialVersionUID = -1126938232236628615L;
	private boolean pure;
	private String lineage;
	private boolean firstBorn;
	private int daysAwaysFromMother;
	
	@Override
	public String sacrifice() {
		return "This lamb represents the purity of the Messiah! It is pure ... Sacrificed!";
	}

}
