package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Priest extends Levite{

	private static final long serialVersionUID = 1040183050452376213L;
	private static Priest instancia = new Priest();
	private Priest() {}
	
	@OneToOne
	private Temple temple;
	
	@Override
	public void updatePurity(boolean p) {
		if(p) {
			this.purity = true;
		}
	}
	
	public static Priest getInstancia() {
		return instancia;
	}

}
