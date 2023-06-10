package com.projetpoo.demo.admin.enseignant;

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
@RequestMapping("/projet/admin/enseignant")
public class enseignantController {
 
    @Autowired
    private enseignantService enseignantService;
 
    @GetMapping("/{name}")
    public enseignant getEnsByName(@PathVariable String name) {
        return enseignantService.findByName(name);
    }
 
    @PostMapping("")
    public void createEns(@RequestBody enseignant enseignant) {
        enseignantService.createEns(enseignant);
    }
 
    @PutMapping("/{id}")
    public void updateEns(@PathVariable Long id, @RequestBody enseignant enseignant) {
        enseignantService.updateEns(id, enseignant);
    }
 
    @DeleteMapping("/{id}")
    public void deleteEns(@PathVariable Long id) {
        enseignantService.deleteEns(id);
    }
}
