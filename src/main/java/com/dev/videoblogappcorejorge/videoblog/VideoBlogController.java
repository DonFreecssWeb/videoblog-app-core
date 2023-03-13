package com.dev.videoblogappcorejorge.videoblog;

import com.dev.videoblogappcorejorge.configuration.JwtService;
import com.dev.videoblogappcorejorge.exceptions.VideoBlogException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class VideoBlogController {
    private final VideoBlogService videoBlogService;

    private final JwtService jwtService;
    @PostMapping("/create-post")
    public ResponseEntity<String> createPost(
            @RequestBody  VideoBlogDTO videoBlogDTO,
            @RequestHeader("Authorization") String authorization
    ){
        if(!jwtService.validateToken(authorization,videoBlogDTO.getUsername())){
            return ResponseEntity.status(401).body("Token no valid");
        }
        try{
            videoBlogService.createVideoBlog(videoBlogDTO);
          return   ResponseEntity.status(201).body("VideoBlog created");
        }catch (VideoBlogException e){
            return ResponseEntity.status(e.getCode()).body(e.getMessage());
        }
    }
}
