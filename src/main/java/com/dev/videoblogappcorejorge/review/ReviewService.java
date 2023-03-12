package com.dev.videoblogappcorejorge.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    public void  createReview(Review review){
        reviewRepository.save(review);
    }
}
