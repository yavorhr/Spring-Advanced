package com.example.books_rest_api.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends BaseEntity {
  private String firstName;
  private String lastName;
  private Integer age;
  private String publisher;
  private List<Book> books;

  public Author() {
    this.books = new ArrayList<>();
  }

  @OneToMany(mappedBy = "author",
          cascade = CascadeType.ALL,
          fetch = FetchType.EAGER)
  public List<Book> getBooks() {
    return books;
  }

  public String getFirstName() {
    return firstName;
  }

  public Author setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Author setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public Author setAge(Integer age) {
    this.age = age;
    return this;
  }

  public String getPublisher() {
    return publisher;
  }

  public Author setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

  public Author setBooks(List<Book> books) {
    this.books = books;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Author's full name : %s %s", this.firstName, this.lastName))
            .append(System.lineSeparator())
            .append(String.format("Age : %d", this.age))
            .append(System.lineSeparator())
            .append(String.format("Publisher: %s", this.publisher))
            .append(System.lineSeparator())
            .append("Books:").append(System.lineSeparator());

    this.getBooks().forEach(b -> sb.append(b.toString()).append(System.lineSeparator()));

    return sb.toString().trim();
  }
}
