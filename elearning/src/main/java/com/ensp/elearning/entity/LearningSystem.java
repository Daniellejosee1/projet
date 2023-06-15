package com.ensp.elearning.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "learningSystem")
@Getter @Setter
public class LearningSystem {
    @OneToMany(mappedBy = "learningSysteme")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;
    @Column(name = "description", nullable = true, length = 200)
    private String description;

    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public LearningSystem() {
    }
}
