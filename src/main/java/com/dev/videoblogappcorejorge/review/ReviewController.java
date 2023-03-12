package com.dev.videoblogappcorejorge.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @PostMapping("/create-review")
    public ResponseEntity<String> createReview(
            @RequestBody Review review
            ){
                if (review.getBody() == null || review.getBody().isBlank()){
                   return ResponseEntity.badRequest().body("You must place a body");
                }
                if (review.getUsername() == null || review.getUsername().isBlank()){
                    return ResponseEntity.badRequest().body("You must place a username");
                }

                try {
                    reviewService.createReview(review);
                    return  ResponseEntity.status(201).body("Review created");
                }catch (Exception e){
                    return  ResponseEntity.internalServerError().body(e.getMessage());

                }
            }
}
