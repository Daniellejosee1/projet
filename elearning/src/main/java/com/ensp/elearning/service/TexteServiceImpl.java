package com.ensp.elearning.service;
import com.ensp.elearning.entity.Texte;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.TexteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TexteServiceImpl implements TexteServiceSpec{
    @Autowired
    TexteRepository texteRepository;

    @Override
    public Texte create(Texte texte) {
        Texte createdTexte = texteRepository.save(texte);

        return createdTexte;
    }

    @Override
    public Texte update(Texte newTexte) {
        Optional<Texte> beforeTexteOptional = texteRepository.findById(Long.valueOf(newTexte.getId()));
        if(beforeTexteOptional.isPresent()){
            Texte beforeTexte  = beforeTexteOptional.get();
            beforeTexte.setUrl(newTexte.getUrl());
            beforeTexte.setNom(newTexte.getNom());
            newTexte = texteRepository.save(beforeTexte);
        }

        return newTexte;
    }

    @Override
    public Optional<Texte> read(Long id) {
        Optional<Texte> beforeTexteOptional = texteRepository.findById(id);

        return beforeTexteOptional;
    }

    @Override
    public List<Texte> readAll() {
        List<Texte> textes = texteRepository.findAll();
        return textes;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Texte> beforeTexteOptional = this.read(id);
        if(beforeTexteOptional.isPresent()){
            texteRepository.delete(beforeTexteOptional.get());
            return  true;
        }
        return false;
    }
}
