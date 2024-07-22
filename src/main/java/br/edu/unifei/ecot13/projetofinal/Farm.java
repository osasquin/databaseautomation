package br.edu.unifei.ecot13.projetofinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Farm implements Serializable {
    private static final long serialVersionUID = 7700560633403534079L;

    @OneToMany(mappedBy = "farm")
    private List<Flock> flocks = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    private String name;
    private String location;
    private int maxCapacity;
}
