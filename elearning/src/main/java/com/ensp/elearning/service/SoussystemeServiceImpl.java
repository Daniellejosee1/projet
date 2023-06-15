package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Soussysteme;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.SoussystemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoussystemeServiceImpl implements SoussystemeServiceSpec{

    @Autowired
    SoussystemeRepository soussystemeRepository;

    @Override
    public Soussysteme create(Soussysteme soussysteme) {
        Soussysteme createdSoussysteme = soussystemeRepository.save(soussysteme);

        return createdSoussysteme;
    }

    @Override
    public Soussysteme update(Soussysteme newSoussysteme) {
        Optional<Soussysteme> beforeSoussystemeOptional = soussystemeRepository.findById(Long.valueOf(newSoussysteme.getId()));
        if(beforeSoussystemeOptional.isPresent()){
            Soussysteme beforeSoussysteme  = beforeSoussystemeOptional.get();
            beforeSoussysteme.setNom(newSoussysteme.getNom());
            newSoussysteme = soussystemeRepository.save(beforeSoussysteme);
        }

        return newSoussysteme;
    }

    @Override
    public Optional<Soussysteme> read(Long id) {
        Optional<Soussysteme> beforeSoussystemeOptional = soussystemeRepository.findById(id);

        return beforeSoussystemeOptional;
    }

    @Override
    public List<Soussysteme> readAll() {
        List<Soussysteme> soussystemes = soussystemeRepository.findAll();
        return soussystemes;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Soussysteme> beforeSoussystemeOptional = this.read(id);
        if(beforeSoussystemeOptional.isPresent()){
            soussystemeRepository.delete(beforeSoussystemeOptional.get());
            return  true;
        }
        return false;
    }
}
