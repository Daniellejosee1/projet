package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Lecon;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface LeconSpec {
    String create(Lecon lecon, Model model);

    String getLeconCreateForm(Model model);


    @GetMapping("/lecons/get_update_form/{id}")
    String getLeconUpdateForm(@PathVariable("id") Long id, Model model);

    String update(Lecon lecon, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
