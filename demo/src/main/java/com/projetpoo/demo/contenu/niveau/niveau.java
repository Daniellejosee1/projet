package com.projetpoo.demo.contenu.niveau;

import java.io.Serializable;
import java.util.List;

import com.projetpoo.demo.contenu.matiere.matiere;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "niveau")
public class niveau implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nivname", nullable = false)
    private String name;

    public niveau(String name, com.projetpoo.demo.contenu.cycle.cycle cycle) {
        this.name = name;
        this.cycle = cycle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.cycle.cycle getCycle() {
        return cycle;
    }

    public void setCycle(com.projetpoo.demo.contenu.cycle.cycle cycle) {
        this.cycle = cycle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcycle", nullable = false)
    private com.projetpoo.demo.contenu.cycle.cycle cycle;

    @OneToMany(mappedBy = "niveau")
    private List<matiere> matieres;

    public List<matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<matiere> matieres) {
        this.matieres = matieres;
    }

// getters and setters
}
