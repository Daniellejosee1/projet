package com.ensp.elearning.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Entity(name = "lecon")
@Getter
@Setter

public class Lecon {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
	@Column(name = "titre", nullable = true, length = 200)
		private String titre;
		@ManyToOne
		Chapitre chapitre;
		
		@OneToMany (mappedBy="lecon")
		private List<Video> videos;
		@OneToMany (mappedBy="lecon")
		private List<Audio> audios;
		@OneToMany (mappedBy="lecon")
		private List <Texte> texte;

	@Override
	public String toString() {
		return "Lecon{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", chapitre=" + chapitre +
				", videos=" + videos +
				", audios=" + audios +
				", texte=" + texte +
				'}';
	}

	public Lecon() {
	}
}
