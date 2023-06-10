package com.projetpoo.demo.media.video;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "video")
public class video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vidname", nullable = false)
    private String name;

    @Column(name = "vidurl", nullable = false)
    private String url;

    @Column(name = "cloudinaryurl", nullable = false)
    private String cloudurl;

    public String getCloudurl() {
        return cloudurl;
    }

    public void setCloudurl(String cloudurl) {
        this.cloudurl = cloudurl;
    }

    public video(String name, String url, com.projetpoo.demo.contenu.lesson.lesson lesson) {
        this.name = name;
        this.url = url;
        this.lesson = lesson;
    }

    public video(String name, String url, String cloudurl, com.projetpoo.demo.contenu.lesson.lesson lesson) {
        this.name = name;
        this.url = url;
        this.cloudurl = cloudurl;
        this.lesson = lesson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.projetpoo.demo.contenu.lesson.lesson getLesson() {
        return lesson;
    }

    public void setLesson(com.projetpoo.demo.contenu.lesson.lesson lesson) {
        this.lesson = lesson;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idles", nullable = false)
    private com.projetpoo.demo.contenu.lesson.lesson lesson;

}