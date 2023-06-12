package com.projetpoo.demo.media.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface videoRepository extends JpaRepository<video, Long>{}
