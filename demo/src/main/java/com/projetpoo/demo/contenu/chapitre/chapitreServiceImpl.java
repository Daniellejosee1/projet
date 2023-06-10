package com.projetpoo.demo.contenu.chapitre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chapitreServiceImpl implements chapitreService {

    @Autowired
    private chapitreRepository chapitreRepository;

    @Override
    public List<chapitre> getAllchapitres() {
        return chapitreRepository.findAll();
    }

    @Override
    public chapitre getChapById(Long id) {
        return chapitreRepository.findById(id).orElse(null);
    }

    @Override
    public void createChap(chapitre chapitre) {
        chapitreRepository.save(chapitre);
    }

    @Override
    public void updateChap(Long id, chapitre chapitre) {
        chapitre existingChap = chapitreRepository.findById(id).orElse(null);
        if (existingChap != null) {
            existingChap.setName(chapitre.getName());
            existingChap.setMatiere(chapitre.getMatiere());
            chapitreRepository.save(existingChap);
        }
    }

    @Override
    public void deleteChap(Long id) {
        chapitreRepository.deleteById(id);
    }
}
