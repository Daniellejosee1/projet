package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "sousSysteme")
@Getter
@Setter

public class Soussysteme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom", nullable = true, length = 200)
	private String nom;
	@ManyToOne
	LearningSystem learningSystem;
	@OneToMany(mappedBy = "sousSysteme")
	List<Cycle> cycles;

	@Override
	public String toString() {
		return "Soussysteme{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", learningSystem=" + learningSystem +
				", cycles=" + cycles +
				'}';
	}

	public Soussysteme() {
	}
}