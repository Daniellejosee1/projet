package com.ensp.elearning.service;
import com.ensp.elearning.entity.LearningSystem;
import com.ensp.elearning.entity.Video;
import com.ensp.elearning.repository.LearningSystemRepository;
import com.ensp.elearning.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoServiceSpec{
    @Autowired
    VideoRepository videoRepository;

    @Override
    public Video create(Video video) {
        Video createdVideo = videoRepository.save(video);

        return createdVideo;
    }

    @Override
    public Video update(Video newVideo) {
        Optional<Video> beforeVideoOptional = videoRepository.findById(Long.valueOf(newVideo.getId()));
        if(beforeVideoOptional.isPresent()){
            Video beforeVideo  = beforeVideoOptional.get();
            beforeVideo.setUrl(newVideo.getUrl());
            beforeVideo.setNom(newVideo.getNom());
            newVideo = videoRepository.save(beforeVideo);
        }

        return newVideo;
    }

    @Override
    public Optional<Video> read(Long id) {
        Optional<Video> beforeVideoOptional = videoRepository.findById(id);

        return beforeVideoOptional;
    }

    @Override
    public List<Video> readAll() {
        List<Video> videos = videoRepository.findAll();
        return videos;
    }

    @Override
    public boolean delete(Long id) {
        Optional<Video> beforeVideoOptional = this.read(id);
        if(beforeVideoOptional.isPresent()){
            videoRepository.delete(beforeVideoOptional.get());
            return  true;
        }
        return false;
    }
}
