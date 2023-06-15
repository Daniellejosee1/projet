package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Niveau;

import java.util.List;
import java.util.Optional;
public interface NiveauServiceSpec {
    Niveau create(Niveau niveau);
    Niveau update(Niveau niveau);
    Optional<Niveau> read(Long id);
    List<Niveau> readAll();
    boolean delete(Long id);
}
