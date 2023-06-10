package com.projetpoo.demo.contenu.subsystem;

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
@RequestMapping("/projet/contenu/subsystem")
public class subsystemController {

    @Autowired
    private subsystemService subsystemService;

    @GetMapping("")
    public List<subsystem> getAllsubsystems() {
        return subsystemService.getAllsubsystems();
    }

    @GetMapping("/{id}")
    public subsystem getSubsysById(@PathVariable Long id) {
        return subsystemService.getSubsysById(id);
    }

    @PostMapping("")
    public void createSubsys(@RequestBody subsystem subsystem) {
        subsystemService.createSubsys(subsystem);
    }

    @PutMapping("/{id}")
    public void updateSubsys(@PathVariable Long id, @RequestBody subsystem subsystem) {
        subsystemService.updateSubsys(id, subsystem);
    }

    @DeleteMapping("/{id}")
    public void deleteSubsys(@PathVariable Long id) {
        subsystemService.deleteSubsys(id);
    }
}
