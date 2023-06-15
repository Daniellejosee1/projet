package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Texte;

import java.util.List;
import java.util.Optional;
public interface TexteServiceSpec {
    Texte create(Texte texte);
    Texte update(Texte texte);
    Optional<Texte> read(Long id);
    List<Texte> readAll();
    boolean delete(Long id);
}
