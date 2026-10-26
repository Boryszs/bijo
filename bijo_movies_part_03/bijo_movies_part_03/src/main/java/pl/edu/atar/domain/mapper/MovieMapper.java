package pl.edu.atar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.atar.domain.dto.CreateMovieDto;
import pl.edu.atar.domain.entity.Movie;

@Component
public class MovieMapper implements Converter<Movie, CreateMovieDto> {

    @Override
    public Movie convert(CreateMovieDto from) {
        Movie movie = new Movie();
        movie.setTitle(from.getTitle());
        movie.setImage(from.getImage());
        movie.setYear(from.getYear());
        movie.setVideoId(from.getVideoId());
        return movie;
    }
}
