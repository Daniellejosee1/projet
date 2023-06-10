package com.projetpoo.demo.contenu.matiere;

import java.util.List;

public interface matiereService {
    
    List<matiere> getAllmatieres();

    matiere getMatById(Long id);

    void createMat(matiere matiere);

    void updateMat(Long id, matiere matiere);

    void deleteMat(Long id);

}
