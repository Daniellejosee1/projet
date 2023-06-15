package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "texte")
@Getter
@Setter
public class Texte {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Column(name = "nom", nullable = true, length = 200)
	String nom;
	@Column(name = "nom", nullable = true, length = 200)
	String url;
	@ManyToOne
	Lecon lecon;
	/**
	 * @param id
	 * @param nom
	 * @param url
	 * @param lecon
	 */
	@Override
	public String toString() {
		return "Texte{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", url='" + url + '\'' +
				", lecon=" + lecon +
				'}';
	}

	public Texte() {
	}
}
