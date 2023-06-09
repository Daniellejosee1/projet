package com.projetpoo.demo.contenu.systeme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class systemeServiceImpl implements systemeService {
 
    @Autowired
    private systemeRepository systemeRepository;
 
    @Override
    public List<systeme> getAllsystemes() {
        return systemeRepository.findAll();
    }
 
    @Override
    public systeme getSysById(Long id) {
        return systemeRepository.findById(id).orElse(null);
    }
 
    @Override
    public void createSys(systeme systeme) {
        systemeRepository.save(systeme);
    }
 
    @Override
    public void updateSys(Long id, systeme systeme) {
        systeme existingsysteme = systemeRepository.findById(id).orElse(null);
        if (existingsysteme != null) {
            existingsysteme.setName(systeme.getName());
            systemeRepository.save(existingsysteme);
        }
    }
 
    @Override
    public void deleteSys(Long id) {
        systemeRepository.deleteById(id);
    }
}

