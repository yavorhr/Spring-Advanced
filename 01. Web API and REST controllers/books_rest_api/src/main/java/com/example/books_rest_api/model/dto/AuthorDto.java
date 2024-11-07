package com.example.books_rest_api.model.dto;

public class AuthorDto {
  private Long id;
  private String fullName;

  public AuthorDto() {
  }

  public Long getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public AuthorDto setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public AuthorDto setId(Long id) {
    this.id = id;
    return this;
  }
}
