package com.projetpoo.demo.contenu.cycle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projet/contenu/cycle")
public class cycleController {

    @Autowired
    private cycleService cycleService;

    @GetMapping("")
    public List<cycle> getAllcycles() {
        return cycleService.getAllcycles();
    }

    @GetMapping("/{id}")
    public cycle getCycleById(@PathVariable Long id) {
        return cycleService.getCycleById(id);
    }

    @PostMapping("")
    public void createCycle(@RequestBody cycle cycle) {
       cycleService.createCycle(cycle);
    }

    @PutMapping("/{id}")
    public void updateCycle(@PathVariable Long id, @RequestBody cycle cycle) {
        cycleService.updateCycle(id, cycle);
    }

    @DeleteMapping("/{id}")
    public void deleteCycle(@PathVariable Long id) {
        cycleService.deleteCycle(id);
    }
}


