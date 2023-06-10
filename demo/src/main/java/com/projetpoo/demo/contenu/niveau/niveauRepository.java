package com.projetpoo.demo.contenu.niveau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface niveauRepository extends JpaRepository<niveau, Long> {
}
