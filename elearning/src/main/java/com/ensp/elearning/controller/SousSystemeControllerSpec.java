package com.ensp.elearning.controller;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Soussysteme;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface SousSystemeControllerSpec {
    String create(Soussysteme soussysteme, Model model);

    String getSoussystemeCreateForm(Model model);

    String getSoussystemeUpdateForm(Long id, Model model);


    String update(Soussysteme soussysteme, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
