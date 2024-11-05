package com.example.books_rest_api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "author")
public class Author extends BaseEntity {
  private String firstName;
  private String lastName;
  private Integer age;
  private String publisher;

  public Author() {
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

}
