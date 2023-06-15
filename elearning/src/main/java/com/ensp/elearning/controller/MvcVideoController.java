package com.ensp.elearning.controller;
import com.ensp.elearning.entity.Audio;
import com.ensp.elearning.entity.Video;
import com.ensp.elearning.service.AudioServiceSpec;
import com.ensp.elearning.service.VideoServiceSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MvcVideoController implements VideoSpec{

    @Autowired
    VideoServiceSpec videoServiceSpec;
    @Override
    @PostMapping("/videos/create")
    public String create(@ModelAttribute("video") Video video, Model model) {

        Video createdVideo = videoServiceSpec.create(video);
        model.addAttribute("video", createdVideo);
        return "video/create_video.html";
    }

    @Override
    @GetMapping("/videos/get_create_form")
    public String getVideoCreateForm(Model model) {
        Video myVideo = new Video();
        model.addAttribute("video", myVideo);

        return "video/create_video.html";
    }
    @Override
    @GetMapping("/videos/get_update_form/{id}")
    public String getVideoUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Video> optionalVideo = videoServiceSpec.read(id);
        if(optionalVideo.isPresent()) {
            Video myVideo = optionalVideo.get();
            model.addAttribute("video", myVideo);

            return "video/update_video.html";
        }

        return "error_page.html";
    }

    @Override
    @PostMapping("/videos/update")
    public String update(@ModelAttribute("video")   Video video, Model model) {

        Video createdVideo = videoServiceSpec.update(video);
        model.addAttribute("video", createdVideo);
        return "video/create_video.html";
    }

    @Override
    @GetMapping("/videos/show_video/{id}")
    public String read(Long id, Model model) {
        Optional<Video> video = videoServiceSpec.read(id);
        model.addAttribute("video", video.get());

        return "video_detail";
    }

    @Override
    @GetMapping("/videos")
    public String readAll(Model model) {
        List<Video> videoList = videoServiceSpec.readAll();
        model.addAttribute("videos", videoList);

        return "video/list_video.html";
    }

    @GetMapping("/videos/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        boolean res = videoServiceSpec.delete(id);
        if (res){
            return readAll(model);
        }
        return "error_page.html";
    }
}
