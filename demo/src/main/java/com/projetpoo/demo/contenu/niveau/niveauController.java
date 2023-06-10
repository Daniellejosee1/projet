package com.projetpoo.demo.contenu.niveau;

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
@RequestMapping("/projet/contenu/niveau")
public class niveauController {

    @Autowired
    private niveauService niveauService;

    @GetMapping("")
    public List<niveau> getAllniveaux() {
        return niveauService.getAllniveaux();
    }

    @GetMapping("/{id}")
    public niveau getNivById(@PathVariable Long id) {
        return niveauService.getNivById(id);
    }

    @PostMapping("")
    public void createNiv(@RequestBody niveau niveau) {
        niveauService.createNiv(niveau);
    }

    @PutMapping("/{id}")
    public void updateNiv(@PathVariable Long id, @RequestBody niveau niveau) {
        niveauService.updateNiv(id, niveau);
    }

    @DeleteMapping("/{id}")
    public void deleteNiv(@PathVariable Long id) {
        niveauService.deleteNiv(id);
    }
}
