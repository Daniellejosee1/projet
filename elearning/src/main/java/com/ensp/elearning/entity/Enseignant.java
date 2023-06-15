package com.ensp.elearning.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "enseignant")
@Getter @Setter
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "name", nullable = false, length = 255, unique = true)
    private String name;
    @Column(name = "description", nullable = true, length = 200)
    private  String description;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "telephone")
    private int telephone;
    @Column(name = "email")
    private String email;

    public Enseignant() {
    }
    @Override
    public String toString() {
        return "Enseignant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", birthday=" + birthday +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                '}';
    }
}