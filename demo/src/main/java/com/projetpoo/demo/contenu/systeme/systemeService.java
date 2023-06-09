package com.projetpoo.demo.contenu.systeme;

import java.util.List;

public interface systemeService {
 
    List<systeme> getAllsystemes();
 
    systeme getSysById(Long id);
 
    void createSys(systeme systeme);
 
    void updateSys(Long id, systeme systeme);
 
    void deleteSys(Long id);
}

