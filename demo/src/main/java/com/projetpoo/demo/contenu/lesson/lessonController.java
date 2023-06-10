package com.projetpoo.demo.contenu.lesson;

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
@RequestMapping("/projet/contenu/lesson")
public class lessonController {

    @Autowired
    private lessonService lessonService;

    @GetMapping("")
    public List<lesson> getAlllessons() {
        return lessonService.getAlllessons();
    }

    @GetMapping("/{id}")
    public lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLesById(id);
    }

    @PostMapping("")
    public void createLes(@RequestBody lesson lesson) {
        lessonService.createLes(lesson);
    }

    @PutMapping("/{id}")
    public void updateLes(@PathVariable Long id, @RequestBody lesson lesson) {
        lessonService.updateLes(id, lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLes(@PathVariable Long id) {
        lessonService.deleteLes(id);
    }
}
