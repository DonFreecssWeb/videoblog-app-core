package com.dev.videoblogappcorejorge.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/create-rating")
    public ResponseEntity<String> createRating(
            @RequestBody Rating rating
    ){

        if(rating.getRating() == 0 ){
            ResponseEntity.badRequest().body("You must to place a rating");
        }
        if(rating.getUsername() == null || rating.getUsername().isBlank()){
            ResponseEntity.badRequest().body("You must to place a username");
        }
        try {
            ratingService.createRating(rating);
            return ResponseEntity.status(201).body("Rating created");
        }catch ( Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
