package com.projetpoo.demo.contenu.niveau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class niveauServiceImpl implements niveauService {

@Autowired
private niveauRepository niveauRepository;

@Override
public List<niveau> getAllniveaux() {
    return niveauRepository.findAll();
}

@Override
public niveau getNivById(Long id) {
    return niveauRepository.findById(id).orElse(null);
}

@Override
public void createNiv(niveau niveau) {
    niveauRepository.save(niveau);
}

@Override
public void updateNiv(Long id, niveau niveau) {
    niveau existingNiv = niveauRepository.findById(id).orElse(null);
    if (existingNiv != null) {
        existingNiv.setName(niveau.getName());
        existingNiv.setCycle(niveau.getCycle());
        niveauRepository.save(existingNiv);
    }
}

@Override
public void deleteNiv(Long id) {
    niveauRepository.deleteById(id);
}
}