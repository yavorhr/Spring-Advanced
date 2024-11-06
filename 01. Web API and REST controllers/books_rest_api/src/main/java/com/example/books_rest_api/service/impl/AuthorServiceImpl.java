package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.entity.Author;
import com.example.books_rest_api.repository.AuthorRepository;
import com.example.books_rest_api.service.AuthorService;
import org.springframework.stereotype.Service;

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
  public void initAuthors() {

    if (this.authorRepository.count() == 0) {
      System.out.println("Please insert authors: ");
//      Hristo Botev - Elin Pelin - Ivan Vazov - Yordan Yovkov - Hristo Smirnenski
      String[] authors = scanner.nextLine().split(" - ");

      for (int i = 0; i < authors.length; i++) {
        Author author = new Author();

        String[] tokens = authors[i].split(" ");

        author
                .setFirstName(tokens[0])
                .setLastName(tokens[1]);

        this.authorRepository.save(author);
      }
    }
  }
}


