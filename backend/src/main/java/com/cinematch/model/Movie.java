
package com.cinematch.model;
import jakarta.persistence.*;

@Entity
public class Movie {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 private String title;
 private String genre;
 private String language;
 private String country;
 private String ott;

 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public String getTitle(){return title;}
 public void setTitle(String title){this.title=title;}
 public String getGenre(){return genre;}
 public void setGenre(String genre){this.genre=genre;}
 public String getLanguage(){return language;}
 public void setLanguage(String language){this.language=language;}
 public String getCountry(){return country;}
 public void setCountry(String country){this.country=country;}
 public String getOtt(){return ott;}
 public void setOtt(String ott){this.ott=ott;}
}
