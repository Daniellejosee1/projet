package com.ensp.elearning.repository;

import com.ensp.elearning.entity.Texte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TexteRepository extends JpaRepository<Texte, Long> {
}
