package com.projetpoo.demo.contenu.lesson;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessons")
public class lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesname", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idchap", nullable = false)
    private com.projetpoo.demo.contenu.chapitre.chapitre chapitre;

    public lesson(String name, com.projetpoo.demo.contenu.chapitre.chapitre chapitre) {
        this.name = name;
        this.chapitre = chapitre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.chapitre.chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(com.projetpoo.demo.contenu.chapitre.chapitre chapitre) {
        this.chapitre = chapitre;
    }

// getters and setters
}
