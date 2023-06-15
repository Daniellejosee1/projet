package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "chapitre")
@Getter
@Setter
public class Chapitre {
	
	@ManyToOne
	Matiere matiere;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "libelle_chap", nullable = true, length = 200)
	String libelle_chap;
	@OneToMany(mappedBy="chapitre")
	List <Lecon> listelecons ;

	@Override
	public String toString() {
		return "Chapitre{" +
				"matiere=" + matiere +
				", id=" + id +
				", libelle_chap='" + libelle_chap + '\'' +
				", listelecons=" + listelecons +
				'}';
	}
}
