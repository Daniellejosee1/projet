package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "cycle")
@Getter
@Setter

public class Cycle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom", nullable = true, length = 200)
	private String nom;
	@OneToMany(mappedBy= "cycle")
	List<Niveau> niveaux;
	@ManyToOne
	Soussysteme sousSysteme;

	@Override
	public String toString() {
		return "Cycle{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", niveaux=" + niveaux +
				", sousSysteme=" + sousSysteme +
				'}';
	}

	public Cycle() {
	}
}
