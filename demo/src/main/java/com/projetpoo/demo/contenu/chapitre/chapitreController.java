package com.projetpoo.demo.contenu.chapitre;

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
@RequestMapping("/projet/contenu/chapitres")
public class chapitreController {

    @Autowired
    private chapitreService chapitreService;

    @GetMapping("")
    public List<chapitre> getAllchapitres() {
        return chapitreService.getAllchapitres();
    }

    @GetMapping("/{id}")
    public chapitre getChapById(@PathVariable Long id) {
        return chapitreService.getChapById(id);
    }

    @PostMapping("")
    public void createChap(@RequestBody chapitre chapitre) {
        chapitreService.createChap(chapitre);
    }

    @PutMapping("/{id}")
    public void updateChap(@PathVariable Long id, @RequestBody chapitre chapitre) {
        chapitreService.updateChap(id, chapitre);
    }

    @DeleteMapping("/{id}")
    public void deleteChap(@PathVariable Long id) {
        chapitreService.deleteChap(id);
    }
}
