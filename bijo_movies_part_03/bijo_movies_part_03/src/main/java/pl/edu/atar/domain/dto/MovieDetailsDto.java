package pl.edu.atar.domain.dto;

import java.io.Serializable;

public class MovieDetailsDto implements Serializable {

    private String title;
    private String videoId;

    public MovieDetailsDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
