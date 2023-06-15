package com.ensp.elearning.controller;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Matiere;
import org.springframework.ui.Model;
public interface MatiereSpec {
    String create(Matiere matiere, Model model);

    String getMatiereCreateForm(Model model);

    String getMatiereUpdateForm(Long id, Model model);

    String update(Matiere matiere, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
