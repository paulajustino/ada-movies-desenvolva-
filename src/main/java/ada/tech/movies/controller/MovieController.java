package ada.tech.movies.controller;

import ada.tech.movies.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    public MovieController() {
        movies.add(new Movie(
                        "The Fantastic 4: First Steps",
                        "https://image.tmdb.org/t/p/w500/hlWOAWRKSno6UxaE0IXDFVvmzTf.jpg",
                        "No vibrante cenário de um mundo retrofuturista inspirado nos anos 1960, a Primeira Família da Marvel é forçada a equilibrar seus papéis como heróis com a força de seus laços familiares, enquanto defendem a Terra de um deus espacial voraz chamado Galactus e sua enigmática arauta, a Surfista Prateada.",
                        "2025-05-15",
                        "Aventura"
                ));
        movies.add(new Movie(
                        "How to Train Your Dragon",
                        "https://image.tmdb.org/t/p/w500/vdvEClt3J8sFWxyMo0Jm7JpouEo.jpg",
                        "Na montanhosa Ilha de Berk, vikings e dragões são inimigos implacáveis há gerações, mas Soluço é diferente. Filho do Chefe Stoico, o Imenso, o criativo e subestimado Soluço desafia séculos de tradição ao fazer amizade com Banguela, um temido dragão Fúria da Noite. Essa relação improvável revela a verdadeira natureza dos dragões, abalando as bases da sociedade viking.",
                        "2025-06-06",
                        "Animação"
                )
        );
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam(required = false) String genre) {
        if (genre == null) {
            return movies;
        }
        return movies.stream().filter(filme -> filme.getGenre().equalsIgnoreCase(genre)).toList();
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        movies.add(movie);
    }


}
