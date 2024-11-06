package com.example.books_rest_api.model.dto;

import java.time.LocalDate;

public class BookDto {
  private Long id;
  private String title;
  private LocalDate releaseDate;
  private Integer copies;
  private AuthorDto author;
  private String publisher;

  public BookDto() {
  }

  public Long getId() {
    return id;
  }

  public AuthorDto getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
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

  public BookDto setTitle(String title) {
    this.title = title;
    return this;
  }

  public BookDto setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  public BookDto setCopies(Integer copies) {
    this.copies = copies;
    return this;
  }

  public BookDto setAuthor(AuthorDto author) {
    this.author = author;
    return this;
  }

  public BookDto setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

  public BookDto setId(Long id) {
    this.id = id;
    return this;
  }
}
