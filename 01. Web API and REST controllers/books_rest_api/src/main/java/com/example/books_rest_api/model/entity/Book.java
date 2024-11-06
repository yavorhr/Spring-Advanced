package com.example.books_rest_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
  private String title;
  private LocalDate releaseDate;
  private Integer copies;
  private Author author;
  private String publisher;

  public Book(String title, LocalDate releaseDate, Integer copies, Author author, String publisher) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.copies = copies;
    this.author = author;
    this.publisher = publisher;
  }

  public Book() {
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

  @ManyToOne(fetch = FetchType.EAGER)
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

  public Book setPublisher(String publisher) {
    this.publisher = publisher;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb
            .append(String.format("Title : %s\n", this.title))
            .append(String.format("Release Date: %s\n", this.releaseDate))
            .append(String.format("Copies: %d\n", this.copies));

    return sb.toString().trim();
  }
}
