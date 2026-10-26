package pl.edu.atar.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;

// Jackson tworzy obiekt z JSON-a przez Builder (klasa nie ma setterów ani publicznego konstruktora)
@JsonDeserialize(builder = CreateMovieDto.Builder.class)
public class CreateMovieDto implements Serializable {
    private String title;
    private String image;
    private Integer year;
    private String videoId;

    private CreateMovieDto(Builder builder) {
        title = builder.title;
        image = builder.image;
        year = builder.year;
        videoId = builder.videoId;
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

    public String getVideoId() {
        return videoId;
    }

    @Override
    public String toString() {
        return "CreateMovieDto{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", year=" + year +
                ", videoId='" + videoId + '\'' +
                '}';
    }

    public static final class Builder {
        private String title;
        private String image;
        private Integer year;
        private String videoId;

        public Builder() {
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

        public Builder videoId(String videoId) {
            this.videoId = videoId;
            return this;
        }

        public Builder fromPrototype(CreateMovieDto prototype) {
            this.title = prototype.getTitle();
            this.image = prototype.getImage();
            this.year = prototype.getYear();
            this.videoId = prototype.getVideoId();
            return this;
        }

        public CreateMovieDto build() {
            return new CreateMovieDto(this);
        }
    }
}
