package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "matiere")
@Getter
@Setter
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom", nullable = true, length = 200)
	private String nom;
	@ManyToOne
	private Niveau niveau;
	private String description;
	@OneToMany(mappedBy  = "matiere")
	private List <Chapitre> listechap;
	/**
	 * @return the id
	 */
	@Override
	public String toString() {
		return "Matiere{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", niveau=" + niveau +
				", description='" + description + '\'' +
				", listechap=" + listechap +
				'}';
	}

	public Matiere() {
	}
}
