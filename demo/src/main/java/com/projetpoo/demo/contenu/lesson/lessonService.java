package com.projetpoo.demo.contenu.lesson;

import java.util.List;

public interface lessonService {

    List<lesson> getAlllessons();
    
    lesson getLesById(Long id);
    
    void createLes(lesson lesson);
    
    void updateLes(Long id, lesson lesson);

    void deleteLes(Long id);
    }
