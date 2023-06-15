package com.ensp.elearning.controller;

import com.ensp.elearning.entity.Enseignant;
import com.ensp.elearning.service.EnseignantServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcEnseignantControler implements EnseignantControllerSpec {
    @Autowired
    EnseignantServiceSpec enseignantServiceSpec;
    @Override
    @PostMapping("/enseignants/create")
    public String create(@ModelAttribute("enseignant") Enseignant enseignant, Model model) {

        Enseignant createdEnseignant = enseignantServiceSpec.create(enseignant);
        model.addAttribute("enseignant", createdEnseignant);
        return "enseignant/create_enseignant.html";
    }

    @Override
    @GetMapping("/enseignants/get_create_form")
    public String getEnseignantCreateForm(Model model) {
        Enseignant myEnseignant = new Enseignant();
        model.addAttribute("enseignant", myEnseignant);

        return "enseignant/create_enseignant.html";
    }
    @Override
    @GetMapping("/enseignants/get_update_form/{id}")
    public String getEnseignantUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Enseignant> optionalEnseignant = enseignantServiceSpec.read(id);
        if(optionalEnseignant.isPresent()) {
            Enseignant myEnseignant = optionalEnseignant.get();
            model.addAttribute("enseignant", myEnseignant);

            return "enseignant/update_enseignant.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/enseignants/update")
    public String update(@ModelAttribute("enseignant")   Enseignant enseignant, Model model) {

        Enseignant createdEnseignant = enseignantServiceSpec.update(enseignant);
        model.addAttribute("enseignant", createdEnseignant);
        return "enseignant/create_enseignant.html";
    }

    @Override
    @GetMapping("/enseignants/show_system/{id}")
    public String read(Long id, Model model) {
        Optional<Enseignant> enseignant = enseignantServiceSpec.read(id);
        model.addAttribute("enseignant", enseignant.get());

        return "enseignant_detail";
    }

    @Override
    @GetMapping("/enseignants")
    public String readAll(Model model) {
        List<Enseignant> enseignantList = enseignantServiceSpec.readAll();
        model.addAttribute("enseignants", enseignantList);

        return "enseignant/list_enseignant.html";
    }

    @GetMapping("/enseignants/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = enseignantServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
