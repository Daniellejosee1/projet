package com.projetpoo.demo.contenu.systeme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.io.Serializable;
import java.util.List;

import com.projetpoo.demo.contenu.subsystem.subsystem;

@Entity
@Table(name = "systeme")
public class systeme implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "sysname")
    private String name;

    public systeme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public List<subsystem> getSubsystems() {
        return subsystems;
    }

    public void setSubsystems(List<subsystem> subsystems) {
        this.subsystems = subsystems;
    }

    @OneToMany(mappedBy = "systeme")
    private List<subsystem> subsystems;
    // getters and setters
}


