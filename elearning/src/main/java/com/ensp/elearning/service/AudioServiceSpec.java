package com.ensp.elearning.service;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.LearningSystem;

import java.util.List;
import java.util.Optional;
public interface AudioServiceSpec {
    Audio create(Audio audio);
    Audio update(Audio audio);
    Optional<Audio> read(Long id);
    List<Audio> readAll();
    boolean delete(Long id);
}
