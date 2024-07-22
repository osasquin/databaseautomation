package br.edu.unifei.ecot13.projetofinal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public abstract class Levite implements Serializable{

	private static final long serialVersionUID = -472074331951136518L;
	protected boolean purity;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	public abstract void updatePurity(boolean p);

}
