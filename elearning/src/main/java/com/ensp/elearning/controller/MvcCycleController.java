package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.Cycle;
import com.ensp.elearning.service.AudioServiceSpec;
import com.ensp.elearning.service.CycleServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcCycleController implements CycleSpec{

    @Autowired
    CycleServiceSpec cycleServiceSpec;
    @Override
    @PostMapping("/cycles/create")
    public String create(@ModelAttribute("cycle") Cycle cycle, Model model) {

        Cycle createdCycle = cycleServiceSpec.create(cycle);
        model.addAttribute("cycle", createdCycle);
        return "cycle/create_cycle.html";
    }

    @Override
    @GetMapping("/cycles/get_create_form")
    public String getCycleCreateForm(Model model) {
        Cycle myCycle = new Cycle();
        model.addAttribute("cycle", myCycle);

        return "cycle/create_cycle.html";
    }
    @Override
    @GetMapping("/cycles/get_update_form/{id}")
    public String getCycleUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Cycle> optionalCycle = cycleServiceSpec.read(id);
        if(optionalCycle.isPresent()) {
            Cycle myCycle = optionalCycle.get();
            model.addAttribute("cycle", myCycle);

            return "cycle/update_cycle.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/cycles/update")
    public String update(@ModelAttribute("cycle")   Cycle cycle, Model model) {

        Cycle createdCycle = cycleServiceSpec.update(cycle);
        model.addAttribute("cycle", createdCycle);
        return "cycle/create_cycle.html";
    }

    @Override
    @GetMapping("/cycles/show_cycle/{id}")
    public String read(Long id, Model model) {
        Optional<Cycle> cycle = cycleServiceSpec.read(id);
        model.addAttribute("cycle", cycle.get());

        return "cycle_detail";
    }

    @Override
    @GetMapping("/cycles")
    public String readAll(Model model) {
        List<Cycle> cycleList = cycleServiceSpec.readAll();
        model.addAttribute("cycles", cycleList);

        return "cycle/list_cycle.html";
    }

    @GetMapping("/cycles/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = cycleServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
