package ada.tech.movies.repository;

import ada.tech.movies.model.Movie;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import static ada.tech.movies.utils.SpecificationUtils.isNotNullOrEmpty;
import static ada.tech.movies.utils.SpecificationUtils.likeIgnoreCase;

public class MovieSpecification {

    // Specification<Movie> é basicamente uma função que gera a cláusula WHERE da query de forma dinâmica.
    public static Specification<Movie> filterByParams(
            String title,
            String imageUrl,
            String description,
            String releaseDate,
            String genre
    ) {
        return (root, query, builder) -> {

            // Cria um predicado inicial equivalente a "true"
            Predicate predicate = builder.conjunction();

            if (isNotNullOrEmpty(title)) {
                predicate = builder.and(predicate, likeIgnoreCase(builder, root.get("title"), title));
            }

            if (isNotNullOrEmpty(imageUrl)) {
                predicate = builder.and(predicate, builder.equal(root.get("imageUrl"), imageUrl));
            }

            if (isNotNullOrEmpty(description)) {
                predicate = builder.and(predicate, likeIgnoreCase(builder, root.get("description"), description));
            }

            if (isNotNullOrEmpty(releaseDate)) {
                predicate = builder.and(predicate, builder.equal(root.get("releaseDate"), releaseDate));
            }

            if (isNotNullOrEmpty(genre)) {
                predicate = builder.and(predicate, likeIgnoreCase(builder, root.get("genre"), genre));
            }

            return predicate;
        };
    }
}
