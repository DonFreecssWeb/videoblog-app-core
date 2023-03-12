package com.dev.videoblogappcorejorge.videoblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoBlogService   {

    @Autowired
    VideoBlogRepository videoBlogRepository;

    public void createVideoBlog(VideoBlog videoBlog){

        videoBlogRepository.save(videoBlog);

    }

}
