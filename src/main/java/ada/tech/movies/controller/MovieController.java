package ada.tech.movies.controller;

import ada.tech.movies.model.Movie;
import ada.tech.movies.repository.MovieRepository;
import ada.tech.movies.repository.MovieSpecification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movieRepository.save(movie);
    }

    @GetMapping
    public List<Movie> getMovies(
            @RequestParam(required = false) String title,
            @RequestParam(name = "image_url", required = false) String imageUrl,
            @RequestParam(required = false) String description,
            @RequestParam(name = "release_date", required = false) String releaseDate,
            @RequestParam(required = false) String genre
    ) {
        return movieRepository.findAll(
                MovieSpecification.filterByParams(title, imageUrl, description, releaseDate, genre)
        );
    }
}

