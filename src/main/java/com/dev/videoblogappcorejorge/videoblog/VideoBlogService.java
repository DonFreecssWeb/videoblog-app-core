package com.dev.videoblogappcorejorge.videoblog;

import com.dev.videoblogappcorejorge.exceptions.VideoBlogException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoBlogService   {


    private final VideoBlogRepository videoBlogRepository;

    public void createVideoBlog(VideoBlogDTO videoBlogDTO) throws VideoBlogException {
        if(!isRequestCompleted(videoBlogDTO)){
            throw new   VideoBlogException(400,"Request no contains necessary data");
        }
        try{
            videoBlogRepository.save(videoBlogDTO.toEntity());
        }catch (Exception e){
            throw new VideoBlogException(511,e.getMessage());
        }
    }

    public boolean isRequestCompleted(VideoBlogDTO videoBlogDTO){
        if(videoBlogDTO.getTitle()== null || videoBlogDTO.getUrlVideo().isBlank()
        || videoBlogDTO.getDescription() == null || videoBlogDTO.getDescription().isBlank()
        || videoBlogDTO.getUrlVideo() == null || videoBlogDTO.getUrlVideo().isBlank()
        || videoBlogDTO.getUsername() == null || videoBlogDTO.getUsername().isBlank()){
            return  false;
        }else{
            return true;
        }



        /*
        if(videoBlogDTO.getTitle()== null || videoBlogDTO.getUrlVideo().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a title");
        }
        if(videoBlogDTO.getDescription() == null || videoBlogDTO.getDescription().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a description");
        }
        if(videoBlogDTO.getUrlVideo() == null || videoBlogDTO.getUrlVideo().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a url video");
        }
        if(videoBlogDTO.getUsername() == null || videoBlogDTO.getUsername().isBlank()){
            return  ResponseEntity.badRequest().body("You must place a username");
        }*/
    }

}
