package com.projetpoo.demo.contenu.subsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class subsystemServiceImpl implements subsystemService {

    @Autowired
    private subsystemRepository subsystemRepository;

    @Override
    public List<subsystem> getAllsubsystems() {
        return subsystemRepository.findAll();
    }

    @Override
    public subsystem getSubsysById(Long id) {
        return subsystemRepository.findById(id).orElse(null);
    }

    @Override
    public void createSubsys(subsystem subsystem) {
        subsystemRepository.save(subsystem);
    }

    @Override
    public void updateSubsys(Long id, subsystem subsystem) {
        subsystem existingsubsystem = subsystemRepository.findById(id).orElse(null);
        if (existingsubsystem != null) {
            existingsubsystem.setName(subsystem.getName());
            existingsubsystem.setSysteme(subsystem.getSysteme());
            existingsubsystem.setCycles(subsystem.getCycles());
            subsystemRepository.save(existingsubsystem);
        }
    }

    @Override
    public void deleteSubsys(Long id) {
        subsystemRepository.deleteById(id);
    }
}
