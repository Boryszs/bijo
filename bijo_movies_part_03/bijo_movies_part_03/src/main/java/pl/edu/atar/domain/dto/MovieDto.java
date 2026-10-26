package pl.edu.atar.domain.dto;

import java.io.Serializable;

public class MovieDto implements Serializable {

    private Long movieId;
    private String title;
    private String image;
    private Integer year;

    private MovieDto(Builder builder) {
        movieId = builder.movieId;
        title = builder.title;
        image = builder.image;
        year = builder.year;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getYear() {
        return year;
    }

    public static final class Builder {
        private Long movieId;
        private String title;
        private String image;
        private Integer year;

        public Builder() {
        }

        public Builder movieId(Long movieId) {
            this.movieId = movieId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder fromPrototype(MovieDto prototype) {
            this.movieId = prototype.getMovieId();
            this.title = prototype.getTitle();
            this.image = prototype.getImage();
            this.year = prototype.getYear();
            return this;
        }

        public MovieDto build() {
            return new MovieDto(this);
        }
    }
}
