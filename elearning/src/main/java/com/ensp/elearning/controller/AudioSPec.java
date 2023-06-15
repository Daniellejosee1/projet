package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.LearningSystem;
import org.springframework.ui.Model;
public interface AudioSPec {
    String create(Audio audio, Model model);

    String getAudioCreateForm(Model model);

    String getAudioUpdateForm(Long id, Model model);

    String update(Audio audio, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
