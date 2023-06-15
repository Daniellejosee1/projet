package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Niveau;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauServiceImpl implements NiveauServiceSpec{
    @Autowired
    NiveauRepository niveauRepository;

    @Override
    public Niveau create(Niveau niveau) {
        Niveau createdNiveau = niveauRepository.save(niveau);

        return createdNiveau;
    }

    @Override
    public Niveau update(Niveau newNiveau) {
        Optional<Niveau> beforeNiveauOptional = niveauRepository.findById(Long.valueOf(newNiveau.getId()));
        if(beforeNiveauOptional.isPresent()){
            Niveau beforeNiveau  = beforeNiveauOptional.get();
            beforeNiveau.setNom(newNiveau.getNom());
            newNiveau = niveauRepository.save(beforeNiveau);
        }

        return newNiveau;
    }

    @Override
    public Optional<Niveau> read(Long id) {
        Optional<Niveau> beforeNiveauOptional = niveauRepository.findById(id);

        return beforeNiveauOptional;
    }

    @Override
    public List<Niveau> readAll() {
        List<Niveau> niveaus = niveauRepository.findAll();
        return niveaus;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Niveau> beforeNiveauOptional = this.read(id);
        if(beforeNiveauOptional.isPresent()){
            niveauRepository.delete(beforeNiveauOptional.get());
            return  true;
        }
        return false;
    }
}
