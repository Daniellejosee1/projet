package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.Niveau;
import com.ensp.elearning.service.AudioServiceSpec;
import com.ensp.elearning.service.NiveauServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcNiveauController implements NiveauSpec{

    @Autowired
    NiveauServiceSpec niveauServiceSpec;
    @Override
    @PostMapping("/niveaus/create")
    public String create(@ModelAttribute("niveau") Niveau niveau, Model model) {

        Niveau createdNiveau = niveauServiceSpec.create(niveau);
        model.addAttribute("niveau", createdNiveau);
        return "niveau/create_niveau.html";
    }

    @Override
    @GetMapping("/niveaus/get_create_form")
    public String getNiveauCreateForm(Model model) {
        Niveau myNiveau = new Niveau();
        model.addAttribute("niveau", myNiveau);

        return "niveau/create_niveau.html";
    }
    @Override
    @GetMapping("/niveaus/get_update_form/{id}")
    public String getNiveauUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Niveau> optionalNiveau = niveauServiceSpec.read(id);
        if(optionalNiveau.isPresent()) {
            Niveau myNiveau = optionalNiveau.get();
            model.addAttribute("niveau", myNiveau);

            return "niveau/update_niveau.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/niveaus/update")
    public String update(@ModelAttribute("niveau")   Niveau niveau, Model model) {

        Niveau createdNiveau = niveauServiceSpec.update(niveau);
        model.addAttribute("niveau", createdNiveau);
        return "niveau/create_niveau.html";
    }

    @Override
    @GetMapping("/niveaus/show_niveau/{id}")
    public String read(Long id, Model model) {
        Optional<Niveau> niveau = niveauServiceSpec.read(id);
        model.addAttribute("niveau", niveau.get());

        return "niveau_detail";
    }

    @Override
    @GetMapping("/niveaus")
    public String readAll(Model model) {
        List<Niveau> niveauList = niveauServiceSpec.readAll();
        model.addAttribute("niveaus", niveauList);

        return "niveau/list_niveau.html";
    }

    @GetMapping("/niveaus/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = niveauServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
