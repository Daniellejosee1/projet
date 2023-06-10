package com.projetpoo.demo.contenu.matiere;

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
@Table(name = "matiere")
public class matiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matname", nullable = false)
    private String name;

    public matiere(String name, com.projetpoo.demo.contenu.niveau.niveau niveau) {
        this.name = name;
        this.niveau = niveau;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.niveau.niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(com.projetpoo.demo.contenu.niveau.niveau niveau) {
        this.niveau = niveau;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idniv", nullable = false)
    private com.projetpoo.demo.contenu.niveau.niveau niveau;

// getters and setters
}
