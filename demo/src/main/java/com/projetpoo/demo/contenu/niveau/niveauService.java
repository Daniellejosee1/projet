package com.projetpoo.demo.contenu.niveau;

import java.util.List;

public interface niveauService {

    List<niveau> getAllniveaux();
    
    niveau getNivById(Long id);
    
    void createNiv(niveau niveau);
    
    void updateNiv(Long id, niveau niveau);
    
    void deleteNiv(Long id);
    }