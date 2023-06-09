package com.projetpoo.demo.admin.enseignant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enseignantRepository extends JpaRepository<enseignant,Long> {
    enseignant findByName(String name);
}
