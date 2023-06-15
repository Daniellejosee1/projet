package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Video;

import java.util.List;
import java.util.Optional;
public interface VideoServiceSpec {
    Video create(Video video);
    Video update(Video video);
    Optional<Video> read(Long id);
    List<Video> readAll();
    boolean delete(Long id);
}
