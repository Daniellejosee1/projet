package com.ensp.elearning.repository;

import com.ensp.elearning.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{
}

