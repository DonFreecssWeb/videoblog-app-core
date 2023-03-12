package com.dev.videoblogappcorejorge.jwt;

import com.dev.videoblogappcorejorge.configuration.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;
    @GetMapping("")
    public ResponseEntity<String> validateToken(
            @RequestHeader String Authorization,
            @RequestParam String username
    ){
            if(jwtService.validateToken(Authorization,username)){
                return ResponseEntity.ok().body("Token valido");
        }else{
                return ResponseEntity.internalServerError().body("Token no valido");
            }
    }
}
