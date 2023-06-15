package com.ensp.elearning.service;
import com.ensp.elearning.entity.Cycle;
import com.ensp.elearning.repository.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CycleServiceImpl implements CycleServiceSpec{
    @Autowired
    CycleRepository cycleRepository;

    @Override
    public Cycle create(Cycle cycle) {
        Cycle createdCycle = cycleRepository.save(cycle);

        return createdCycle;
    }

    @Override
    public Cycle update(Cycle newCycle) {
        Optional<Cycle> beforeCycleOptional = cycleRepository.findById(Long.valueOf(newCycle.getId()));
        if(beforeCycleOptional.isPresent()){
            Cycle beforeCycle  = beforeCycleOptional.get();
            beforeCycle.setNom(newCycle.getNom());
            newCycle = cycleRepository.save(beforeCycle);
        }

        return newCycle;
    }

    @Override
    public Optional<Cycle> read(Long id) {
        Optional<Cycle> beforeCycleOptional = cycleRepository.findById(id);

        return beforeCycleOptional;
    }

    @Override
    public List<Cycle> readAll() {
        List<Cycle> cycles = cycleRepository.findAll();
        return cycles;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Cycle> beforeCycleOptional = this.read(id);
        if(beforeCycleOptional.isPresent()){
            cycleRepository.delete(beforeCycleOptional.get());
            return  true;
        }
        return false;
    }
}
