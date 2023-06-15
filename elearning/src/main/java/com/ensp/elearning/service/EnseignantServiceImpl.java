package com.ensp.elearning.service;

import com.ensp.elearning.entity.Enseignant;
import com.ensp.elearning.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantServiceImpl implements  EnseignantServiceSpec{
    @Autowired
    EnseignantRepository enseignantRepository;

    @Override
    public Enseignant create(Enseignant enseignant) {
        Enseignant createdEnseignant = enseignantRepository.save(enseignant);

        return createdEnseignant;
    }

    @Override
    public Enseignant update(Enseignant newEnseignant) {
        Optional<Enseignant> beforeEnseignantOptional = enseignantRepository.findById(newEnseignant.getId());
        if(beforeEnseignantOptional.isPresent()){
            Enseignant beforeEnseignant  = beforeEnseignantOptional.get();
            beforeEnseignant.setDescription(newEnseignant.getDescription());
            beforeEnseignant.setName(newEnseignant.getName());
            newEnseignant = enseignantRepository.save(beforeEnseignant);
        }

        return newEnseignant;
    }

    @Override
    public Optional<Enseignant> read(Long id) {
        Optional<Enseignant> beforeEnseignantOptional = enseignantRepository.findById(id);

        return beforeEnseignantOptional;
    }

    @Override
    public List<Enseignant> readAll() {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        return enseignants;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Enseignant> beforeEnseignantOptional = this.read(id);
        if(beforeEnseignantOptional.isPresent()){
            enseignantRepository.delete(beforeEnseignantOptional.get());
            return  true;
        }
        return false;
    }
}
