package com.projetpoo.demo.contenu.chapitre;

import java.util.List;

public interface chapitreService {

    List<chapitre> getAllchapitres();
    
    chapitre getChapById(Long id);
    
    void createChap(chapitre chapitre);
    
    void updateChap(Long id, chapitre chapitre);
    
    void deleteChap(Long id);
    }
