package com.projetpoo.demo.contenu.chapitre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chapitreRepository extends JpaRepository<chapitre, Long> {
}
