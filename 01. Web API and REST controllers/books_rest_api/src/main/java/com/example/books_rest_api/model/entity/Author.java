package com.example.books_rest_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
  private String firstName;
  private String lastName;
  private List<Book> books;

  public Author() {
  }

  @OneToMany(mappedBy = "author")
  public List<Book> getBooks() {
    return books;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Author setBooks(List<Book> books) {
    this.books = books;
    return this;
  }

  public Author setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Author setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb
            .append(String.format("Author's full name : %s %s\n", this.firstName, this.lastName))
            .append("Books titles:\n");

    this.getBooks().forEach(b -> sb
            .append(b.toString())
            .append(System.lineSeparator()));

    return sb.toString().trim();
  }
}
