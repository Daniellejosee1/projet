package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.service.AudioServiceSpec;
import com.ensp.elearning.service.LearningSystemServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcAudioController implements AudioSPec{
    @Autowired
    AudioServiceSpec audioServiceSpec;
    @Override
    @PostMapping("/audios/create")
    public String create(@ModelAttribute("audio") Audio audio, Model model) {

        Audio createdAudio = audioServiceSpec.create(audio);
        model.addAttribute("audio", createdAudio);
        return "audio/create_audio.html";
    }

    @Override
    @GetMapping("/audios/get_create_form")
    public String getAudioCreateForm(Model model) {
        Audio myAudio = new Audio();
        model.addAttribute("audio", myAudio);

        return "audio/create_audio.html";
    }
    @Override
    @GetMapping("/audios/get_update_form/{id}")
    public String getAudioUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Audio> optionalAudio = audioServiceSpec.read(id);
        if(optionalAudio.isPresent()) {
            Audio myAudio = optionalAudio.get();
            model.addAttribute("audio", myAudio);

            return "audio/update_audio.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/audios/update")
    public String update(@ModelAttribute("audio")   Audio audio, Model model) {

        Audio createdAudio = audioServiceSpec.update(audio);
        model.addAttribute("audio", createdAudio);
        return "audio/create_audio.html";
    }

    @Override
    @GetMapping("/audios/show_audio/{id}")
    public String read(Long id, Model model) {
        Optional<Audio> audio = audioServiceSpec.read(id);
        model.addAttribute("audio", audio.get());

        return "audio_detail";
    }

    @Override
    @GetMapping("/audios")
    public String readAll(Model model) {
        List<Audio> audioList = audioServiceSpec.readAll();
        model.addAttribute("audios", audioList);

        return "audio/list_audio.html";
    }

    @GetMapping("/audios/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = audioServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
