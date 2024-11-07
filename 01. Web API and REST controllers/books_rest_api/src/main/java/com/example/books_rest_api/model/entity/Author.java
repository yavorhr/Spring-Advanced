package com.example.books_rest_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
  private String fullName;
  private List<Book> books;

  public Author() {
  }

  public String getFullName() {
    return fullName;
  }

  public Author(String fullName) {
    this.fullName = fullName;
    this.books = new ArrayList<>();
  }

  @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
  public List<Book> getBooks() {
    return books;
  }

  public Author setBooks(List<Book> books) {
    this.books = books;
    return this;
  }

  public Author setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb
            .append(String.format("Author's name name : %s \n", this.fullName))
            .append("Books titles:\n");

    this.getBooks().forEach(b -> sb
            .append(b.toString())
            .append(System.lineSeparator()));

    return sb.toString().trim();
  }
}
