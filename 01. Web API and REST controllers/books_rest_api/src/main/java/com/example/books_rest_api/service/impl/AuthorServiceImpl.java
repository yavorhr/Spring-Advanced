package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.entity.Author;
import com.example.books_rest_api.repository.AuthorRepository;
import com.example.books_rest_api.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

@Service
public class AuthorServiceImpl implements AuthorService {
  private final AuthorRepository authorRepository;
  private final Scanner scanner;

  public AuthorServiceImpl(AuthorRepository authorRepository, Scanner scanner) {
    this.authorRepository = authorRepository;
    this.scanner = scanner;
  }

  @Override
  public void initAuthors() throws IOException {

    if (this.authorRepository.count() == 0) {
      List<String> lines =
              Files.readAllLines(Path.of("src/main/resources/static/authors"));

      for (String line : lines) {

        String[] tokens = line.split(" ");
        String firstName = tokens[0];
        String lastName = tokens[1];

        this.authorRepository.save(new Author(firstName,lastName));
      }
    }
  }

  @Override
  public Author findAuthorByFirstAndLastNames(String firstName, String lastName) {
    return this.authorRepository.findByFirstNameAndLastName(firstName,lastName).get();
  }
}



