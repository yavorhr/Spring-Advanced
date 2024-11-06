package com.example.books_rest_api.model.dto;

public class AuthorDto {
  private Long id;
  private String firstName;
  private String lastName;


  public AuthorDto() {
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public AuthorDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AuthorDto setId(Long id) {
    this.id = id;
    return this;
  }

  public AuthorDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
}
