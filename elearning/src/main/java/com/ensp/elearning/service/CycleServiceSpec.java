package com.ensp.elearning.service;
import com.ensp.elearning.entity.Cycle;

import java.util.List;
import java.util.Optional;
public interface CycleServiceSpec {
    Cycle create(Cycle learningSystem);
    Cycle update(Cycle learningSystem);
    Optional<Cycle> read(Long id);
    List<Cycle> readAll();
    boolean delete(Long id);
}
