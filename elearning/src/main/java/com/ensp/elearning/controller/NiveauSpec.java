package com.ensp.elearning.controller;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Niveau;
import org.springframework.ui.Model;
public interface NiveauSpec {
    String create(Niveau niveau, Model model);

    String getNiveauCreateForm(Model model);

    String getNiveauUpdateForm(Long id, Model model);

    String update(Niveau niveau, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
