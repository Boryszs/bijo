package pl.edu.atar.domain.dto;

import java.io.Serializable;

public class MovieDetailsDto implements Serializable {

    private String title;
    private String videoId;

    private MovieDetailsDto(Builder builder) {
        title = builder.title;
        videoId = builder.videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoId() {
        return videoId;
    }

    public static final class Builder {
        private String title;
        private String videoId;

        public Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }

        public Builder fromPrototype(MovieDetailsDto prototype) {
            this.title = prototype.getTitle();
            this.videoId = prototype.getVideoId();
            return this;
        }

        public MovieDetailsDto build() {
            return new MovieDetailsDto(this);
        }
    }
}
