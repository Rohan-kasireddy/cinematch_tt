
package com.cinematch.config;
import org.springframework.context.annotation.*;
import org.springframework.boot.CommandLineRunner;
import com.cinematch.repository.MovieRepository;
import com.cinematch.model.Movie;

@Configuration
public class DataLoader {
 @Bean
 CommandLineRunner load(MovieRepository repo){
  return args->{
   Movie[] movies = new Movie[]{
    createMovie("RRR","Action","Telugu","India","Netflix"),
    createMovie("Pushpa","Action","Telugu","India","Prime"),
    createMovie("Avengers: Endgame","Action","English","USA","Disney+"),
    createMovie("The Dark Knight","Action","English","USA","Netflix"),
    createMovie("Inception","Sci-Fi","English","USA","Netflix"),
    createMovie("Interstellar","Sci-Fi","English","USA","Prime"),
    createMovie("The Matrix","Sci-Fi","English","USA","HBO Max"),
    createMovie("Parasite","Thriller","Korean","South Korea","Hulu"),
    createMovie("Spirited Away","Animation","Japanese","Japan","HBO Max"),
    createMovie("Your Name","Animation","Japanese","Japan","Netflix"),
    createMovie("Gladiator","Drama","English","USA","Prime"),
    createMovie("The Shawshank Redemption","Drama","English","USA","Netflix"),
    createMovie("The Godfather","Crime","English","USA","Paramount+"),
    createMovie("Pulp Fiction","Crime","English","USA","Hulu"),
    createMovie("Dangal","Drama","Hindi","India","Disney+"),
    createMovie("3 Idiots","Comedy","Hindi","India","Netflix"),
    createMovie("Bahubali 2","Action","Telugu","India","Netflix"),
    createMovie("The Lunchbox","Romance","Hindi","India","Netflix"),
    createMovie("Joker","Thriller","English","USA","HBO Max"),
    createMovie("La La Land","Musical","English","USA","Prime"),
    createMovie("Titanic","Romance","English","USA","Hulu"),
    createMovie("Fight Club","Drama","English","USA","Netflix"),
    createMovie("Forrest Gump","Drama","English","USA","Prime"),
    createMovie("Whiplash","Drama","English","USA","Hulu"),
    createMovie("Avengers: Infinity War","Action","English","USA","Disney+"),
    createMovie("Black Panther","Action","English","USA","Disney+"),
    createMovie("Guardians of the Galaxy","Action","English","USA","Disney+"),
    createMovie("The Lion King","Animation","English","USA","Disney+"),
    createMovie("Coco","Animation","English","USA","Disney+"),
    createMovie("The Irishman","Crime","English","USA","Netflix"),
    createMovie("Mad Max: Fury Road","Action","English","USA","HBO Max"),
    createMovie("The Hobbit: An Unexpected Journey","Fantasy","English","New Zealand","Prime"),
    createMovie("Avatar","Sci-Fi","English","USA","Disney+"),
    createMovie("The Lord of the Rings: The Fellowship of the Ring","Fantasy","English","New Zealand","Prime"),
    createMovie("The Departed","Crime","English","USA","Netflix"),
    createMovie("The Social Network","Drama","English","USA","Netflix"),
    createMovie("Oldboy","Thriller","Korean","South Korea","Hulu"),
    createMovie("Pan’s Labyrinth","Fantasy","Spanish","Spain","HBO Max")
   };
   for(Movie m : movies) {
    repo.save(m);
   }
  };
 }

 private Movie createMovie(String title, String genre, String language, String country, String ott) {
  Movie m = new Movie();
  m.setTitle(title);
  m.setGenre(genre);
  m.setLanguage(language);
  m.setCountry(country);
  m.setOtt(ott);
  return m;
 }
}
