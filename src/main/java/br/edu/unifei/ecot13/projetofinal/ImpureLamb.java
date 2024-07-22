package br.edu.unifei.ecot13.projetofinal;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ImpureLamb extends SacrificialLamb{

	private static final long serialVersionUID = 5308628743450665123L;
	private Lamb lamb;
	private boolean pure;
	private String impurityDetail;
	private boolean diseased;
	
	public String sacrifice() {
		return "The lamb does not meet the requirements for the sacrifice; it is impure in the eyes of God.";
	}

	}

	
	
	
	

