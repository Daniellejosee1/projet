package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Soussysteme;

import java.util.List;
import java.util.Optional;
public interface SoussystemeServiceSpec {
    Soussysteme create(Soussysteme soussysteme);
    Soussysteme update(Soussysteme soussysteme);
    Optional<Soussysteme> read(Long id);
    List<Soussysteme> readAll();
    boolean delete(Long id);
}
