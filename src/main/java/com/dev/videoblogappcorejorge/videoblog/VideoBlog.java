package com.dev.videoblogappcorejorge.videoblog;

import com.dev.videoblogappcorejorge.rating.Rating;
import com.dev.videoblogappcorejorge.review.Review;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder
@Document(collection = "video-blog")
public class VideoBlog {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private String username;
    private String urlVideo;

    @DocumentReference
    private List<Review> reviewIds;
    @DocumentReference
    private List<Rating> ratingsIds;

}
