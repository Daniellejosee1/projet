package com.ensp.elearning.repository;

import com.ensp.elearning.entity.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, Long> {
}
