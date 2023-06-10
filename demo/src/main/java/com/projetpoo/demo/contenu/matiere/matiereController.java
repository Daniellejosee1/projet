package com.projetpoo.demo.contenu.matiere;

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
@RequestMapping("/projet/contenu/matieres")
public class matiereController {

    @Autowired
    private matiereService matiereService;

    @GetMapping("")
    public List<matiere> getAllmatieres() {
        return matiereService.getAllmatieres();
    }

    @GetMapping("/{id}")
    public matiere getmatiereById(@PathVariable Long id) {
        return matiereService.getMatById(id);
    }

    @PostMapping("")
    public void creatematiere(@RequestBody matiere matiere) {
        matiereService.createMat(matiere);
    }

    @PutMapping("/{id}")
    public void updatematiere(@PathVariable Long id, @RequestBody matiere matiere) {
        matiereService.updateMat(id, matiere);
    }

    @DeleteMapping("/{id}")
    public void deletematiere(@PathVariable Long id) {
        matiereService.deleteMat(id);
    }
}