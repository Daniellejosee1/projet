package com.ensp.elearning.service;
import com.ensp.elearning.entity.Chapitre;
import com.ensp.elearning.entity.Cycle;

import java.util.List;
import java.util.Optional;
public interface ChapitreServiceSpec {
    Chapitre create(Chapitre learningSystem);
    Chapitre update(Chapitre learningSystem);
    Optional<Chapitre> read(Long id);
    List<Chapitre> readAll();
    boolean delete(Long id);
}
