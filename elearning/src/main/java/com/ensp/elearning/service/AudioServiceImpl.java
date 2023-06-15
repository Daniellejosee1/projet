package com.ensp.elearning.service;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.repository.AudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudioServiceImpl implements AudioServiceSpec{
    @Autowired
    AudioRepository audioRepository;

    @Override
    public Audio create(Audio audio) {
        Audio createdAudio = audioRepository.save(audio);

        return createdAudio;
    }

    @Override
    public Audio update(Audio newAudio) {
        Optional<Audio> beforeAudioOptional = audioRepository.findById(Long.valueOf(newAudio.getId()));
        if(beforeAudioOptional.isPresent()){
            Audio beforeAudio  = beforeAudioOptional.get();
            beforeAudio.setUrl(newAudio.getUrl());
            beforeAudio.setNom(newAudio.getNom());
            newAudio = audioRepository.save(beforeAudio);
        }

        return newAudio;
    }

    @Override
    public Optional<Audio> read(Long id) {
        Optional<Audio> beforeAudioOptional = audioRepository.findById(id);

        return beforeAudioOptional;
    }

    @Override
    public List<Audio> readAll() {
        List<Audio> audios = audioRepository.findAll();
        return audios;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Audio> beforeAudioOptional = this.read(id);
        if(beforeAudioOptional.isPresent()){
            audioRepository.delete(beforeAudioOptional.get());
            return  true;
        }
        return false;
    }
}
