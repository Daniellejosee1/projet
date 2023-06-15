package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Cycle;
import com.ensp.elearning.entity.LearningSystem;
import org.springframework.ui.Model;
public interface CycleSpec {
    String create(Cycle cycle, Model model);

    String getCycleCreateForm(Model model);

    String getCycleUpdateForm(Long id, Model model);

    String update(Cycle cycle, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
