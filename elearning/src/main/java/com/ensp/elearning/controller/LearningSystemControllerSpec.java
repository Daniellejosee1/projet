package com.ensp.elearning.controller;

import com.ensp.elearning.entity.LearningSystem;
import org.springframework.ui.Model;

public interface LearningSystemControllerSpec {
    String create(LearningSystem learningSystem, Model model);

    String getSystemCreateForm(Model model);

    String getSystemUpdateForm(Long id, Model model);

    String update(LearningSystem learningSystem, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);


}
