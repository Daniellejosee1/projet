package com.projetpoo.demo.contenu.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface lessonRepository extends JpaRepository<lesson, Long> {
}
