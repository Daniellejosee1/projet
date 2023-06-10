package com.projetpoo.demo.contenu.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class lessonServiceImpl implements lessonService {

    @Autowired
    private lessonRepository lessonRepository;

    @Override
    public List<lesson> getAlllessons() {
        return lessonRepository.findAll();
    }

    @Override
    public lesson getLesById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public void createLes(lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void updateLes(Long id, lesson lesson) {
        lesson existingLesson = lessonRepository.findById(id).orElse(null);
        if (existingLesson != null) {
            existingLesson.setName(lesson.getName());
            existingLesson.setChapitre(lesson.getChapitre());
            lessonRepository.save(existingLesson);
        }
    }

    @Override
    public void deleteLes(Long id) {
        lessonRepository.deleteById(id);
    }
}
