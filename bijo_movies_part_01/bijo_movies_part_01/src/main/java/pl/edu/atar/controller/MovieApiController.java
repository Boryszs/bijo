package pl.edu.atar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.atar.domain.dto.CreateMovieDto;
import pl.edu.atar.domain.dto.MovieDto;
import pl.edu.atar.service.MovieService;

import java.util.List;


@RestController
@RequestMapping(value="/api")
public class MovieApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieApiController.class);

    private final MovieService movieService;

    @Autowired
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovieDto>> getMovies() {
        LOGGER.info("find all movies");

        List<MovieDto> moviesDto = movieService.findAll();
        return new ResponseEntity<>(moviesDto, HttpStatus.OK);
    }

    @PostMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieDto createMovieDto) {
        LOGGER.info("create movie: {}", createMovieDto);

        MovieDto moviesDto = movieService.create(createMovieDto);
        return new ResponseEntity<>(moviesDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        LOGGER.info("delete movie: {}", id);

        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
