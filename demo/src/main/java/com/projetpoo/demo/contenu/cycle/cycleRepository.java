package com.projetpoo.demo.contenu.cycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cycleRepository extends JpaRepository<cycle, Long> {
    }

