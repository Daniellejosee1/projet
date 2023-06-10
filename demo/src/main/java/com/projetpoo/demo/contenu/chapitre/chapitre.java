package com.projetpoo.demo.contenu.chapitre;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "chapitre")
public class chapitre implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "chapname")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.matiere.matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(com.projetpoo.demo.contenu.matiere.matiere matiere) {
        this.matiere = matiere;
    }

    public chapitre(String name, com.projetpoo.demo.contenu.matiere.matiere matiere) {
        this.name = name;
        this.matiere = matiere;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idmat", nullable = false)
    private com.projetpoo.demo.contenu.matiere.matiere matiere;
 
    // getters and setters
}

