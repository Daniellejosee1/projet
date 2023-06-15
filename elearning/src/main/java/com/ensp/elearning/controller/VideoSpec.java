package com.ensp.elearning.controller;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Video;
import org.springframework.ui.Model;
public interface VideoSpec {
    String create(Video video, Model model);

    String getVideoCreateForm(Model model);

    String getVideoUpdateForm(Long id, Model model);

    String update(Video video, Model model);

    String read(Long id, Model model);

    String readAll(Model model);

    String delete(Long id, Model model);

}
