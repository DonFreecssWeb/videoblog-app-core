package com.dev.videoblogappcorejorge.videoblog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoBlogDTO {
    private String title;
    private String description;
    private String username;
    private String urlVideo;

    public VideoBlog toEntity(){
        VideoBlog videoBlog = VideoBlog.builder()
                .title(this.title)
                .description(this.title)
                .username(this.username)
                .urlVideo(this.urlVideo)
                .build();

        return  videoBlog;
    }
}
