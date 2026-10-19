package pl.edu.atar.domain.mapper;

import pl.edu.atar.domain.dto.MovieDetailsDto;
import pl.edu.atar.domain.entity.Movie;

public class MovieDetailsMapper implements Converter<MovieDetailsDto, Movie> {

    @Override
    public MovieDetailsDto convert(Movie from) {
        return new MovieDetailsDto(from.getTitle(), from.getVideoId());
    }
}
