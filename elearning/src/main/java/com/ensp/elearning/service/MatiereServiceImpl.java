package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Matiere;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereServiceImpl implements MatiereServiceSPec{
    @Autowired
    MatiereRepository matiereRepository;

    @Override
    public Matiere create(Matiere matiere) {
        Matiere createdMatiere = matiereRepository.save(matiere);

        return createdMatiere;
    }

    @Override
    public Matiere update(Matiere newMatiere) {
        Optional<Matiere> beforeMatiereOptional = matiereRepository.findById(Long.valueOf(newMatiere.getId()));
        if(beforeMatiereOptional.isPresent()){
            Matiere beforeMatiere  = beforeMatiereOptional.get();
            beforeMatiere.setDescription(newMatiere.getDescription());
            beforeMatiere.setNom(newMatiere.getNom());
            beforeMatiere.setNiveau(newMatiere.getNiveau());
            newMatiere = matiereRepository.save(beforeMatiere);
        }

        return newMatiere;
    }

    @Override
    public Optional<Matiere> read(Long id) {
        Optional<Matiere> beforeMatiereOptional = matiereRepository.findById(id);

        return beforeMatiereOptional;
    }

    @Override
    public List<Matiere> readAll() {
        List<Matiere> matieres = matiereRepository.findAll();
        return matieres;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Matiere> beforeMatiereOptional = this.read(id);
        if(beforeMatiereOptional.isPresent()){
            matiereRepository.delete(beforeMatiereOptional.get());
            return  true;
        }
        return false;
    }
}
