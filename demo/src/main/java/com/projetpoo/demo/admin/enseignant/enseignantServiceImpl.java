package com.projetpoo.demo.admin.enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class enseignantServiceImpl implements enseignantService{
    @Autowired
    private enseignantRepository enseignantRepository;

    @Override
    public enseignant findByName(String name) {
        return enseignantRepository.findByName(name);
    }
 
    @Override
    public void createEns(enseignant enseignant) {
        enseignantRepository.save(enseignant);
    }
 
    @Override
    public void updateEns(Long id, enseignant enseignant) {
        enseignant existingEns = enseignantRepository.findById(id).orElse(null);
        if (existingEns != null) {
            existingEns.setName(enseignant.getName());
            existingEns.setPassword(enseignant.getPassword());
            enseignantRepository.save(existingEns);
        }
    }

    @Override
    public void deleteEns(Long id) {
        enseignantRepository.deleteById(id);
    }
}