
package com.cinematch.repository;
import com.cinematch.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>{
 List<Movie> findByGenre(String genre);
 List<Movie> findByLanguage(String language);
 List<Movie> findByCountry(String country);
 List<Movie> findByTitleContainingIgnoreCase(String title);
}
