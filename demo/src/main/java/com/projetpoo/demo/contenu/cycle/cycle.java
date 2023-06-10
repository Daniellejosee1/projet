package com.projetpoo.demo.contenu.cycle;

import java.io.Serializable;
import java.util.List;

import com.projetpoo.demo.contenu.niveau.niveau;

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
@Table(name = "cycle")
public class cycle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cycname")
    private String name;

    public cycle(String name, com.projetpoo.demo.contenu.subsystem.subsystem subsystem) {
        this.name = name;
        this.subsystem = subsystem;
    }

    public String getName() {
        return name;
    }

    public List<niveau> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(List<niveau> niveaux) {
        this.niveaux = niveaux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.subsystem.subsystem getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(com.projetpoo.demo.contenu.subsystem.subsystem subsystem) {
        this.subsystem = subsystem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsubsys", nullable = false)
    private com.projetpoo.demo.contenu.subsystem.subsystem subsystem;

    @OneToMany(mappedBy = "cycle")
    private List<niveau> niveaux;
// getters and setters
}