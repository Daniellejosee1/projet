package com.ensp.elearning.service;

import com.ensp.elearning.entity.LearningSystem;

import java.util.List;
import java.util.Optional;


public interface LearningSystemServiceSpec {
    LearningSystem create(LearningSystem learningSystem);
    LearningSystem update(LearningSystem learningSystem);
    Optional<LearningSystem> read(Long id);
    List<LearningSystem> readAll();
    boolean delete(Long id);

}
