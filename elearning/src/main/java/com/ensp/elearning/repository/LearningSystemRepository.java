package com.ensp.elearning.repository;

import com.ensp.elearning.entity.LearningSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LearningSystemRepository extends JpaRepository<LearningSystem, Long> {
}
