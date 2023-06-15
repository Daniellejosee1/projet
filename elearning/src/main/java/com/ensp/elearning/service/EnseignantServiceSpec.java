package com.ensp.elearning.service;

import com.ensp.elearning.entity.Enseignant;

import java.util.List;
import java.util.Optional;

public interface EnseignantServiceSpec {
    Enseignant create(Enseignant enseignant);
    Enseignant update(Enseignant enseignant);
    Optional<Enseignant> read(Long id);
    List<Enseignant> readAll();
    boolean delete(Long id);
}
