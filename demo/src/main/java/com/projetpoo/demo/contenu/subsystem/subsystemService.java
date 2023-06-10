package com.projetpoo.demo.contenu.subsystem;

import java.util.List;

public interface subsystemService {

    List<subsystem> getAllsubsystems();
    
    subsystem getSubsysById(Long id);
    
    void createSubsys(subsystem subsystem);
    
    void updateSubsys(Long id, subsystem subsystem);
    
    void deleteSubsys(Long id);
}
