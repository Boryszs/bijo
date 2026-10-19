package pl.edu.atar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.edu.atar.domain.dto.CreateMovieDto;
import pl.edu.atar.domain.dto.MovieDetailsDto;
import pl.edu.atar.domain.dto.MovieDto;
import pl.edu.atar.domain.entity.Movie;
import pl.edu.atar.domain.mapper.Converter;
import pl.edu.atar.domain.repository.MovieRepository;
import pl.edu.atar.service.MovieService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final Converter<List<MovieDto>, List<Movie>> movieListMapper;
    private final Converter<Movie, CreateMovieDto> movieMapper;
    private final Converter<MovieDetailsDto, Movie> movieDetailsMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, Converter<List<MovieDto>, List<Movie>> movieListMapper, Converter<Movie, CreateMovieDto> movieMapper, Converter<MovieDetailsDto, Movie> movieDetailsMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.movieMapper = movieMapper;
        this.movieDetailsMapper = movieDetailsMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));
        return movieListMapper.convert(movies);
    }

    @Override
    public Long createMovie(CreateMovieDto createMovieDto) {

        Movie movie = movieMapper.convert(createMovieDto);
        Movie movieSaved = movieRepository.save(movie);

        return movieSaved.getMovieId();
    }

    @Override
    public boolean deleteMovie(Long movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);

        if (movieOptional.isEmpty()) {
            return false;
        }

        movieRepository.deleteById(movieId);

        return true;
    }

    @Override
    public MovieDetailsDto getMovie(Long movieId) {
        return movieRepository.findById(movieId).map(movieDetailsMapper::convert).orElse(null);
    }
}
