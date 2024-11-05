package com.example.books_rest_api.model.dto;

import java.util.List;

public class AuthorDto {
  private String firstName;
  private String lastName;
  private Integer age;
  private String publisher;
  private List<BookDto> books;

  public AuthorDto() {
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Integer getAge() {
    return age;
  }

  public String getPublisher() {
    return publisher;
  }

  public List<BookDto> getBooks() {
    return books;
  }

  public AuthorDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public AuthorDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public AuthorDto setAge(Integer age) {
    this.age = age;
    return this;
  }

  public AuthorDto setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

  public AuthorDto setBooks(List<BookDto> books) {
    this.books = books;
    return this;
  }
}
