package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class FlatFarm extends Farm {
	private static final long serialVersionUID = 3033500227130184360L;
	private float areaOfValley;
	private String typeOfSolo;
	private int numberOfLakes;
}
