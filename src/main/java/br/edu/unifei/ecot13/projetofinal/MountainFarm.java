package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class MountainFarm extends Farm {
	private static final long serialVersionUID = 6805637182626662591L;
	private int maxHeight;
	private float inclinationDegrees;

}
