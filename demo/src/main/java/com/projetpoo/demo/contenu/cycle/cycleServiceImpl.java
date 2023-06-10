package com.projetpoo.demo.contenu.cycle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cycleServiceImpl implements cycleService {

    @Autowired
    private cycleRepository cycleRepository;

    @Override
    public List<cycle> getAllcycles() {
        return cycleRepository.findAll();
    }

    @Override
    public cycle getCycleById(Long id) {
        return cycleRepository.findById(id).orElse(null);
    }

    @Override
    public void createCycle(cycle cycle) {
        cycleRepository.save(cycle);
    }

    @Override
    public void updateCycle(Long id, cycle cycle) {
        cycle existingCycle = cycleRepository.findById(id).orElse(null);
        if (existingCycle != null) {
            existingCycle.setName(cycle.getName());
            existingCycle.setSubsystem(cycle.getSubsystem());
            cycleRepository.save(existingCycle);
        }
    }

    @Override
    public void deleteCycle(Long id) {
        cycleRepository.deleteById(id);
    }
}   