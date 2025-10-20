package ada.tech.movies.repository;

import ada.tech.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {

    /*  Nenhum metodo adicional necessário para consultas dinamicas
        porque o Spring Data JPA junto ao JpaSpecificationExecutor
        fornece o metodo findAll(Specification<T> spec) automaticamente. */
}
