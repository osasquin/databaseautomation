package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Temple {
	private float area;
	private int hollyOfHollies;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	private String location;
	private int capacity;
	
	private Priest priest;
	
}
