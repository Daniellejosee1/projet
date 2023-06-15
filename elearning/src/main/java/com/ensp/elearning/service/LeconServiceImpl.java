package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Lecon;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.LeconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeconServiceImpl implements LeconServiceSpec{
    @Autowired
    LeconRepository leconRepository;

    @Override
    public Lecon create(Lecon lecon) {
        Lecon createdLecon = leconRepository.save(lecon);

        return createdLecon;
    }

    @Override
    public Lecon update(Lecon newLecon) {
        Optional<Lecon> beforeLeconOptional = leconRepository.findById(Long.valueOf(newLecon.getId()));
        if(beforeLeconOptional.isPresent()){
            Lecon beforeLecon  = beforeLeconOptional.get();
            beforeLecon.setTitre(newLecon.getTitre());
            newLecon = leconRepository.save(beforeLecon);
        }

        return newLecon;
    }

    @Override
    public Optional<Lecon> read(Long id) {
        Optional<Lecon> beforeLeconOptional = leconRepository.findById(id);

        return beforeLeconOptional;
    }

    @Override
    public List<Lecon> readAll() {
        List<Lecon> lecons = leconRepository.findAll();
        return lecons;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Lecon> beforeLeconOptional = this.read(id);
        if(beforeLeconOptional.isPresent()){
            leconRepository.delete(beforeLeconOptional.get());
            return  true;
        }
        return false;
    }
}
