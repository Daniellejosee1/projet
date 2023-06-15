package com.ensp.elearning.repository;

import com.ensp.elearning.entity.Lecon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, Long> {
}
