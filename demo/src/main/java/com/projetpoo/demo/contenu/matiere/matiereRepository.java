package com.projetpoo.demo.contenu.matiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface matiereRepository extends JpaRepository<matiere, Long> {
}