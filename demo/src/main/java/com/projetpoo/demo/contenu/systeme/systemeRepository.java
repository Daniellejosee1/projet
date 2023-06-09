package com.projetpoo.demo.contenu.systeme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface systemeRepository extends JpaRepository<systeme, Long> {
}

