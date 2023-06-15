package com.ensp.elearning.service;
import com.ensp.elearning.entity.Lecon;

import java.util.List;
import java.util.Optional;
public interface LeconServiceSpec {
    Lecon create(Lecon lecon);
    Lecon update(Lecon lecon);
    Optional<Lecon> read(Long id);
    List<Lecon> readAll();
    boolean delete(Long id);
}
