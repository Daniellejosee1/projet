package com.projetpoo.demo.contenu.systeme;

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
@RequestMapping("/api/educational_systems")
public class systemeController {
 
    @Autowired
    private systemeService systemeService;
 
    @GetMapping("")
    public List<systeme> getAllsystemes() {
        return systemeService.getAllsystemes();
    }

    @GetMapping("/{id}")
    public systeme getSysById(@PathVariable Long id) {
        return systemeService.getSysById(id);
    }
    
    @PostMapping("")
    public void createSys(@RequestBody systeme systeme) {
        systemeService.createSys(systeme);
    }
    
    @PutMapping("/{id}")
    public void updateSys(@PathVariable Long id, @RequestBody systeme systeme) {
        systemeService.updateSys(id, systeme);
    }

    @DeleteMapping("/{id}")
    public void deleteSys(@PathVariable Long id) {
        systemeService.deleteSys(id);
    }
}
