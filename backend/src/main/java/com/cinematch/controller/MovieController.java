
package com.cinematch.controller;
import com.cinematch.repository.MovieRepository;
import com.cinematch.model.Movie;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieController {

 private final MovieRepository repo;

 public MovieController(MovieRepository repo){this.repo=repo;}

 @GetMapping
 public List<Movie> all(){ return repo.findAll(); }

 @GetMapping("/search")
 public List<Movie> search(@RequestParam(value = "q", required = false) String q){
  if (q == null || q.isBlank()) {
   return repo.findAll();
  }
  return repo.findByTitleContainingIgnoreCase(q);
 }

 @GetMapping("/genre/{g}")
 public List<Movie> byGenre(@PathVariable String g){ return repo.findByGenre(g); }

 @GetMapping("/language/{l}")
 public List<Movie> byLang(@PathVariable String l){ return repo.findByLanguage(l); }

 @GetMapping("/country/{c}")
 public List<Movie> byCountry(@PathVariable String c){ return repo.findByCountry(c); }
}
