package com.projetpoo.demo.contenu.subsystem;

import java.io.Serializable;
import java.util.List;

import com.projetpoo.demo.contenu.cycle.cycle;

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
@Table(name = "subsystem")
public class subsystem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subsysname")
    private String name;

    public subsystem(String name, com.projetpoo.demo.contenu.systeme.systeme systeme) {
        this.name = name;
        this.systeme = systeme;
    }

    public String getName() {
        return name;
    }

    public List<cycle> getCycles() {
        return cycles;
    }

    public void setCycles(List<cycle> cycles) {
        this.cycles = cycles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.projetpoo.demo.contenu.systeme.systeme getSysteme() {
        return systeme;
    }

    public void setSysteme(com.projetpoo.demo.contenu.systeme.systeme systeme) {
        this.systeme = systeme;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsubsys", nullable = false)
    private com.projetpoo.demo.contenu.systeme.systeme systeme;

    @OneToMany(mappedBy = "subsystem")
    private List<cycle> cycles;

}