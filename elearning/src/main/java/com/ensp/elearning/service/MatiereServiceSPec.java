package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Matiere;

import java.util.List;
import java.util.Optional;
public interface MatiereServiceSPec {
    Matiere create(Matiere matiere);
    Matiere update(Matiere matiere);
    Optional<Matiere> read(Long id);
    List<Matiere> readAll();
    boolean delete(Long id);
}
