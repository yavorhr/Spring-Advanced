package com.example.books_rest_api.model.dto;

import java.time.LocalDate;

public class BookDto {
  private String title;
  private LocalDate releaseDate;
  private Integer copies;

  public BookDto() {
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
}
