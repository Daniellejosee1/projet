package com.ensp.elearning.service;
import com.ensp.elearning.entity.Chapitre;
import com.ensp.elearning.repository.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapitreServiceImpl implements ChapitreServiceSpec {
    @Autowired
    ChapitreRepository chapitreRepository;

    @Override
    public Chapitre create(Chapitre chapitre) {
        Chapitre createdChapitre = chapitreRepository.save(chapitre);

        return createdChapitre;
    }

    @Override
    public Chapitre update(Chapitre newChapitre) {
        Optional<Chapitre> beforeChapitreOptional = chapitreRepository.findById(Long.valueOf(newChapitre.getId()));
        if (beforeChapitreOptional.isPresent()) {
            Chapitre beforeChapitre = beforeChapitreOptional.get();
            beforeChapitre.setLibelle_chap(newChapitre.getLibelle_chap());
            newChapitre = chapitreRepository.save(beforeChapitre);
        }

        return newChapitre;
    }

    @Override
    public Optional<Chapitre> read(Long id) {
        Optional<Chapitre> beforeChapitreOptional = chapitreRepository.findById(id);

        return beforeChapitreOptional;
    }

    @Override
    public List<Chapitre> readAll() {
        List<Chapitre> chapitres = chapitreRepository.findAll();
        return chapitres;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Chapitre> beforeChapitreOptional = this.read(id);
        if (beforeChapitreOptional.isPresent()) {
            chapitreRepository.delete(beforeChapitreOptional.get());
            return true;
        }
        return false;
    }
}

