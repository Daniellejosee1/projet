package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Soussysteme;
import com.ensp.elearning.service.SoussystemeServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcSousSystemeController implements SousSystemeControllerSpec{
    @Autowired
    SoussystemeServiceSpec soussystemeServiceSpec;
    @Override
    @PostMapping("/soussystemes/create")
    public String create(@ModelAttribute("soussysteme") Soussysteme soussysteme, Model model) {

        Soussysteme createdSoussysteme = soussystemeServiceSpec.create(soussysteme);
        model.addAttribute("soussysteme", createdSoussysteme);
        return "soussysteme/create_soussysteme.html";
    }

    @Override
    @GetMapping("/soussystemes/get_create_form")
    public String getSoussystemeCreateForm(Model model) {
        Soussysteme mySoussysteme = new Soussysteme();
        model.addAttribute("soussysteme", mySoussysteme);

        return "soussysteme/create_soussysteme.html";
    }
    @Override
    @GetMapping("/soussystemes/get_update_form/{id}")
    public String getSoussystemeUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Soussysteme> optionalSoussysteme = soussystemeServiceSpec.read(id);
        if(optionalSoussysteme.isPresent()) {
            Soussysteme mySoussysteme = optionalSoussysteme.get();
            model.addAttribute("soussysteme", mySoussysteme);

            return "soussysteme/update_soussysteme.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/soussystemes/update")
    public String update(@ModelAttribute("soussysteme")   Soussysteme soussysteme, Model model) {

        Soussysteme createdSoussysteme = soussystemeServiceSpec.update(soussysteme);
        model.addAttribute("soussysteme", createdSoussysteme);
        return "soussysteme/create_soussysteme.html";
    }

    @Override
    @GetMapping("/soussystemes/show_system/{id}")
    public String read(Long id, Model model) {
        Optional<Soussysteme> soussysteme = soussystemeServiceSpec.read(id);
        model.addAttribute("soussysteme", soussysteme.get());

        return "soussysteme_detail";
    }

    @Override
    @GetMapping("/soussystemes")
    public String readAll(Model model) {
        List<Soussysteme> soussystemeList = soussystemeServiceSpec.readAll();
        model.addAttribute("soussystemes", soussystemeList);

        return "soussysteme/list_soussysteme.html";
    }

    @GetMapping("/soussystemes/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = soussystemeServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }

}
