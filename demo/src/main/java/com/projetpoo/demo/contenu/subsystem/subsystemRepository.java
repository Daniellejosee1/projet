package com.projetpoo.demo.contenu.subsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subsystemRepository extends JpaRepository<subsystem, Long> {
}



