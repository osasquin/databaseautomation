package br.edu.unifei.ecot13.projetofinal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Lamb implements Serializable {
    private static final long serialVersionUID = 6347176999104726937L;

    @Id
    private String name;

    @ManyToOne
    private Flock flock;

    private int age;
    private float weight;
    private String color;
    private boolean hasHorn;
}
