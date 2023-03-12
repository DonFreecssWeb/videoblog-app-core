package com.dev.videoblogappcorejorge.videoblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class VideoBlogController {

    @Autowired
    VideoBlogService videoBlogService;

    @PostMapping("/create-post")
    public ResponseEntity<String> createPost(
            @RequestBody  VideoBlog videoBlog
    ){
            if(videoBlog.getTitle()== null || videoBlog.getUrlVideo().isBlank()){
                return  ResponseEntity.badRequest().body("You must place a title");
            }
        if(videoBlog.getDescription() == null || videoBlog.getDescription().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a description");
        }
        if(videoBlog.getUrlVideo() == null || videoBlog.getUrlVideo().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a url video");
        }
        if(videoBlog.getUsername() == null || videoBlog.getUsername().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a username");
        }
        try{
            videoBlogService.createVideoBlog(videoBlog);
          return   ResponseEntity.status(201).body("VideoBlog created");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }


    }
}
