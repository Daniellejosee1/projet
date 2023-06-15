package com.ensp.elearning.repository;

import com.ensp.elearning.entity.Soussysteme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoussystemeRepository extends JpaRepository<Soussysteme, Long> {
}
