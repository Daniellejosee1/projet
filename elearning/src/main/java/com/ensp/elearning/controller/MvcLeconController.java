package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Lecon;
import com.ensp.elearning.service.LeconServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcLeconController implements LeconSpec{

    @Autowired
    LeconServiceSpec leconServiceSpec;
    @Override
    @PostMapping("/lecons/create")
    public String create(@ModelAttribute("lecon") Lecon lecon, Model model) {

        Lecon createdLecon = leconServiceSpec.create(lecon);
        model.addAttribute("lecon", createdLecon);
        return "lecon/create_lecon.html";
    }

    @Override
    @GetMapping("/lecons/get_create_form")
    public String getLeconCreateForm(Model model) {
        Lecon myLecon = new Lecon();
        model.addAttribute("lecon", myLecon);

        return "lecon/create_lecon.html";
    }
    @Override
    @GetMapping("/lecons/get_update_form/{id}")
    public String getLeconUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Lecon> optionalLecon = leconServiceSpec.read(id);
        if(optionalLecon.isPresent()) {
            Lecon myLecon = optionalLecon.get();
            model.addAttribute("lecon", myLecon);

            return "lecon/update_lecon.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/lecons/update")
    public String update(@ModelAttribute("lecon")   Lecon lecon, Model model) {

        Lecon createdLecon = leconServiceSpec.update(lecon);
        model.addAttribute("lecon", createdLecon);
        return "lecon/create_lecon.html";
    }

    @Override
    @GetMapping("/lecons/show_lecon/{id}")
    public String read(Long id, Model model) {
        Optional<Lecon> lecon = leconServiceSpec.read(id);
        model.addAttribute("lecon", lecon.get());

        return "lecon_detail";
    }

    @Override
    @GetMapping("/lecons")
    public String readAll(Model model) {
        List<Lecon> leconList = leconServiceSpec.readAll();
        model.addAttribute("lecons", leconList);

        return "lecon/list_lecon.html";
    }

    @GetMapping("/lecons/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = leconServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
