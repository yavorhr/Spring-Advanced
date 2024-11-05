package com.example.books_rest_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
  private String title;
  private LocalDate releaseDate;
  private Integer copies;
  private Author author;

  public Book() {
  }

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false)
  public Author getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public Integer getCopies() {
    return copies;
  }


  public Book setTitle(String title) {
    this.title = title;
    return this;
  }

  public Book setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Book setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public Book setAuthor(Author author) {
    this.author = author;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    
    sb
            .append(String.format("Title : %s\n", this.title))
            .append(String.format("Release Date: %s\n", this.releaseDate))
            .append(String.format("Copies: %d\n", this.copies));

    return sb.toString().trim();
  }
}
