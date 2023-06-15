package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Chapitre;
import com.ensp.elearning.entity.LearningSystem;
import org.springframework.ui.Model;
public interface ChapitreSpec {
    String create(Chapitre chapitre, Model model);

    String getChapitreCreateForm(Model model);

    String getChapitreUpdateForm(Long id, Model model);

    String update(Chapitre chapitre, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
