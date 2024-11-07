package com.example.books_rest_api.model.dto;

import java.time.LocalDate;

public class AddBookDto {
  private Long id;
  private String title;
  private LocalDate releaseDate;
  private Integer copies;
  private String author;
  private String publisher;

  public AddBookDto() {
  }

  public Long getId() {
    return id;
  }

  public AddBookDto setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public AddBookDto setTitle(String title) {
    this.title = title;
    return this;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public AddBookDto setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public Integer getCopies() {
    return copies;
  }

  public AddBookDto setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public String getAuthor() {
    return author;
  }

  public AddBookDto setAuthor(String author) {
    this.author = author;
    return this;
  }

  public String getPublisher() {
    return publisher;
  }

  public AddBookDto setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }
}
