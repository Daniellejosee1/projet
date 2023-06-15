package com.ensp.elearning.controller;

import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.service.LearningSystemServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcSystemController implements LearningSystemControllerSpec {
    @Autowired
    LearningSystemServiceSpec learningSystemServiceSpec;
    @Override
    @PostMapping("/learning_systems/create")
    public String create(@ModelAttribute("learningSystem")   LearningSystem learningSystem, Model model) {

        LearningSystem createdSystem = learningSystemServiceSpec.create(learningSystem);
        model.addAttribute("learningSystem", createdSystem);
        return "learning_system/create_system.html";
    }

    @Override
    @GetMapping("/learning_systems/get_create_form")
    public String getSystemCreateForm(Model model) {
        LearningSystem myLearningSystem = new LearningSystem();
        model.addAttribute("learningSystem", myLearningSystem);

        return "learning_system/create_system.html";
    }
    @Override
    @GetMapping("/learning_systems/get_update_form/{id}")
    public String getSystemUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<LearningSystem> optionalLearningSystem = learningSystemServiceSpec.read(id);
        if(optionalLearningSystem.isPresent()) {
            LearningSystem myLearningSystem = optionalLearningSystem.get();
            model.addAttribute("learningSystem", myLearningSystem);

            return "learning_system/update_system.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/learning_systems/update")
    public String update(@ModelAttribute("learningSystem")   LearningSystem learningSystem, Model model) {

        LearningSystem createdSystem = learningSystemServiceSpec.update(learningSystem);
        model.addAttribute("learningSystem", createdSystem);
        return "learning_system/create_system.html";
    }

    @Override
    @GetMapping("/learning_systems/show_system/{id}")
    public String read(Long id, Model model) {
        Optional<LearningSystem> learningSystem = learningSystemServiceSpec.read(id);
        model.addAttribute("learningSystem", learningSystem.get());

        return "system_detail";
    }

    @Override
    @GetMapping("/learning_systems")
    public String readAll(Model model) {
        List<LearningSystem> learningSystemList = learningSystemServiceSpec.readAll();
        model.addAttribute("systems", learningSystemList);

        return "learning_system/list_system.html";
    }

    @GetMapping("/learning_systems/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = learningSystemServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
