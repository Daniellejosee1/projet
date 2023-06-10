package com.projetpoo.demo.contenu.cycle;

import java.util.List;

public interface cycleService {

    List<cycle> getAllcycles();
    
    cycle getCycleById(Long id);
    
    void createCycle(cycle cycle);
    
    void updateCycle(Long id, cycle cycle);
    
    void deleteCycle(Long id);
    }
