package com.ensp.elearning.service;

import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.repository.LearningSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimpleLearningService  implements  LearningSystemServiceSpec{
    @Autowired
    LearningSystemRepository learningSystemRepository;

    @Override
    public LearningSystem create(LearningSystem learningSystem) {
        LearningSystem createdSystem = learningSystemRepository.save(learningSystem);

        return createdSystem;
    }

    @Override
    public LearningSystem update(LearningSystem newLearningSystem) {
        Optional<LearningSystem> beforeSystemOptional = learningSystemRepository.findById(newLearningSystem.getId());
        if(beforeSystemOptional.isPresent()){
            LearningSystem beforeLearningSystem  = beforeSystemOptional.get();
            beforeLearningSystem.setDescription(newLearningSystem.getDescription());
            beforeLearningSystem.setName(newLearningSystem.getName());
            newLearningSystem = learningSystemRepository.save(beforeLearningSystem);
        }

        return newLearningSystem;
    }

    @Override
    public Optional<LearningSystem> read(Long id) {
        Optional<LearningSystem> beforeSystemOptional = learningSystemRepository.findById(id);

        return beforeSystemOptional;
    }

    @Override
    public List<LearningSystem> readAll() {
        List<LearningSystem> learningSystems = learningSystemRepository.findAll();
        return learningSystems;
    }

    @Override
    public boolean delete(Long id) {
        Optional<LearningSystem> beforeSystemOptional = this.read(id);
        if(beforeSystemOptional.isPresent()){
            learningSystemRepository.delete(beforeSystemOptional.get());
            return  true;
        }
        return false;
    }
}
