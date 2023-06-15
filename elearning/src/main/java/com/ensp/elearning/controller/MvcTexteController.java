package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.Texte;
import com.ensp.elearning.service.AudioServiceSpec;
import com.ensp.elearning.service.TexteServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcTexteController implements TexteSpec{

    @Autowired
    TexteServiceSpec texteServiceSpec;
    @Override
    @PostMapping("/textes/create")
    public String create(@ModelAttribute("texte") Texte texte, Model model) {

        Texte createdTexte = texteServiceSpec.create(texte);
        model.addAttribute("texte", createdTexte);
        return "texte/create_texte.html";
    }

    @Override
    @GetMapping("/textes/get_create_form")
    public String getTexteCreateForm(Model model) {
        Texte myTexte = new Texte();
        model.addAttribute("texte", myTexte);

        return "texte/create_texte.html";
    }
    @Override
    @GetMapping("/textes/get_update_form/{id}")
    public String getTexteUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Texte> optionalTexte = texteServiceSpec.read(id);
        if(optionalTexte.isPresent()) {
            Texte myTexte = optionalTexte.get();
            model.addAttribute("texte", myTexte);

            return "texte/update_texte.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/textes/update")
    public String update(@ModelAttribute("texte")   Texte texte, Model model) {

        Texte createdTexte = texteServiceSpec.update(texte);
        model.addAttribute("texte", createdTexte);
        return "texte/create_texte.html";
    }

    @Override
    @GetMapping("/textes/show_texte/{id}")
    public String read(Long id, Model model) {
        Optional<Texte> texte = texteServiceSpec.read(id);
        model.addAttribute("texte", texte.get());

        return "texte_detail";
    }

    @Override
    @GetMapping("/textes")
    public String readAll(Model model) {
        List<Texte> texteList = texteServiceSpec.readAll();
        model.addAttribute("textes", texteList);

        return "texte/list_texte.html";
    }

    @GetMapping("/textes/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = texteServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
