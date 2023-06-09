package com.projetpoo.demo.admin.enseignant;

public interface enseignantService {
    
    enseignant findByName(String name);
 
    void createEns(enseignant enseignant);
 
    void updateEns(Long id, enseignant enseignant);
 
    void deleteEns(Long id);   
}
