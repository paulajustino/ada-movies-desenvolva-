package ada.tech.movies.controller;

import ada.tech.movies.model.Movie;
import ada.tech.movies.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String genre) {
        if (genre == null) {
            return movieRepository.findAll();
        }
        return movieRepository.findByGenreNative(genre);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }


}

