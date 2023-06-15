package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.Matiere;
import com.ensp.elearning.service.MatiereServiceSPec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcMatiereController implements MatiereSpec{

    @Autowired
    MatiereServiceSPec matiereServiceSpec;
    @Override
    @PostMapping("/matieres/create")
    public String create(@ModelAttribute("matiere") Matiere matiere, Model model) {

        Matiere createdMatiere = matiereServiceSpec.create(matiere);
        model.addAttribute("matiere", createdMatiere);
        return "matiere/create_matiere.html";
    }

    @Override
    @GetMapping("/matieres/get_create_form")
    public String getMatiereCreateForm(Model model) {
        Matiere myMatiere = new Matiere();
        model.addAttribute("matiere", myMatiere);

        return "matiere/create_matiere.html";
    }
    @Override
    @GetMapping("/matieres/get_update_form/{id}")
    public String getMatiereUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Matiere> optionalMatiere = matiereServiceSpec.read(id);
        if(optionalMatiere.isPresent()) {
            Matiere myMatiere = optionalMatiere.get();
            model.addAttribute("matiere", myMatiere);

            return "matiere/update_matiere.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/matieres/update")
    public String update(@ModelAttribute("matiere")   Matiere matiere, Model model) {

        Matiere createdMatiere = matiereServiceSpec.update(matiere);
        model.addAttribute("matiere", createdMatiere);
        return "matiere/create_matiere.html";
    }

    @Override
    @GetMapping("/matieres/show_matiere/{id}")
    public String read(Long id, Model model) {
        Optional<Matiere> matiere = matiereServiceSpec.read(id);
        model.addAttribute("matiere", matiere.get());

        return "matiere_detail";
    }

    @Override
    @GetMapping("/matieres")
    public String readAll(Model model) {
        List<Matiere> matiereList = matiereServiceSpec.readAll();
        model.addAttribute("matieres", matiereList);

        return "matiere/list_matiere.html";
    }

    @GetMapping("/matieres/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = matiereServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
