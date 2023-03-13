package com.dev.videoblogappcorejorge.exceptions;

import lombok.Data;

@Data
public class VideoBlogException  extends  Exception{

    private final int code;
    private final String message;
    public VideoBlogException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
