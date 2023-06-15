package com.ensp.elearning.controller;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Texte;
import org.springframework.ui.Model;
public interface TexteSpec {
    String create(Texte texte, Model model);

    String getTexteCreateForm(Model model);

    String getTexteUpdateForm(Long id, Model model);

    String update(Texte texte, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
