package com.projetpoo.demo.contenu.matiere;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class matiereServiceImpl implements matiereService {
       
    @Autowired
    private matiereRepository matiereRepository;
    
    @Override
    public List<matiere> getAllmatieres() {
        return matiereRepository.findAll();
    }
    @Override
    public matiere getMatById(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }
    
    @Override
    public void createMat(matiere matiere) {
        matiereRepository.save(matiere);
    }
    
    @Override
    public void updateMat(Long id, matiere matiere) {
        matiere existingmatiere = matiereRepository.findById(id).orElse(null);
        if (existingmatiere != null) {
            existingmatiere.setName(matiere.getName());
            existingmatiere.setNiveau(matiere.getNiveau());
            matiereRepository.save(existingmatiere);
        }
    }
    
    @Override
    public void deleteMat(Long id) {
        matiereRepository.deleteById(id);
    }
}