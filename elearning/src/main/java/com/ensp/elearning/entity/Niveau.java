package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "niveau")
@Getter
@Setter
public class Niveau {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom", nullable = true, length = 200)
	private String nom;
	@ManyToOne
	Cycle cycle;
	@OneToMany(mappedBy = "niveau")
	List <Matiere> matieres;
	/**
	 * @param id
	 * @param nom
	 * @param matieres
	 * @param cycle
	 */
	@Override
	public String toString() {
		return "Niveau{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", cycle=" + cycle +
				", matieres=" + matieres +
				'}';
	}

	public Niveau() {
	}
}
