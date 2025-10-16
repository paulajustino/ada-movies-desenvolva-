package ada.tech.movies.repository;

import ada.tech.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //QUERY METHOD
    List<Movie> findByGenre(String genre);

    //JAVA PERSISTENCE QUERY LANGUAGE
    @Query("""
      SELECT m
      FROM Movie m
      WHERE m.genre = :genre
     """)
    List<Movie> findByGenreByJPQL(@Param("genre") String genre);

    //NATIVE QUERY
    @Query(value = """
    SELECT m.*
    FROM movie as m
    WHERE m.genre = :genre
    """, nativeQuery = true)
    List<Movie> findByGenreNative(String genre);

}
