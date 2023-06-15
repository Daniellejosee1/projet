package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Chapitre;
import com.ensp.elearning.service.ChapitreServiceSpec;
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
public class MvcChapitreController implements ChapitreSpec{
    @Autowired
    ChapitreServiceSpec chapitreServiceSpec;
    @Override
    @PostMapping("/chapitres/create")
    public String create(@ModelAttribute("chapitre") Chapitre chapitre, Model model) {

        Chapitre createdChapitre = chapitreServiceSpec.create(chapitre);
        model.addAttribute("chapitre", createdChapitre);
        return "chapitre/create_chapitre.html";
    }

    @Override
    @GetMapping("/chapitres/get_create_form")
    public String getChapitreCreateForm(Model model) {
        Chapitre myChapitre = new Chapitre();
        model.addAttribute("chapitre", myChapitre);

        return "chapitre/create_chapitre.html";
    }
    @Override
    @GetMapping("/chapitres/get_update_form/{id}")
    public String getChapitreUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Chapitre> optionalChapitre = chapitreServiceSpec.read(id);
        if(optionalChapitre.isPresent()) {
            Chapitre myChapitre = optionalChapitre.get();
            model.addAttribute("chapitre", myChapitre);

            return "chapitre/update_chapitre.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/chapitres/update")
    public String update(@ModelAttribute("chapitre")   Chapitre chapitre, Model model) {

        Chapitre createdChapitre = chapitreServiceSpec.update(chapitre);
        model.addAttribute("chapitre", createdChapitre);
        return "chapitre/create_chapitre.html";
    }

    @Override
    @GetMapping("/chapitres/show_chapitre/{id}")
    public String read(Long id, Model model) {
        Optional<Chapitre> chapitre = chapitreServiceSpec.read(id);
        model.addAttribute("chapitre", chapitre.get());

        return "chapitre_detail";
    }

    @Override
    @GetMapping("/chapitres")
    public String readAll(Model model) {
        List<Chapitre> chapitreList = chapitreServiceSpec.readAll();
        model.addAttribute("chapitres", chapitreList);

        return "chapitre/list_chapitre.html";
    }

    @GetMapping("/chapitres/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = chapitreServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
