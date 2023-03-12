package com.dev.videoblogappcorejorge.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public void createRating(Rating rating){
        ratingRepository.save(rating);
    }
}
