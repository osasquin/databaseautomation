package br.edu.unifei.ecot13.projetofinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Flock implements Serializable {
    private static final long serialVersionUID = 7481822287787747365L;

    @ManyToOne
    private Shepherd shepherd;

    @OneToMany(mappedBy = "flock")
    private List<Lamb> lambs = new ArrayList<>();

    @ManyToOne
    private Farm farm;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    private String name;
    private int numberOfLambs;
}
