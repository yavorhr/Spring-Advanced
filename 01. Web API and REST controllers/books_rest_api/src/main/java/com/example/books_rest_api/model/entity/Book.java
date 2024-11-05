package com.example.books_rest_api.model.entity;

import java.time.LocalDate;

public class Book {
  private String title;
  private LocalDate releaseDate;
  private Integer copies;
  private Author author;

  public Book() {
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

  public Author getAuthor() {
    return author;
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
}
