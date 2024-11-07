package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.entity.Author;
import com.example.books_rest_api.repository.AuthorRepository;
import com.example.books_rest_api.service.AuthorService;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public void initAuthors() throws IOException {

    if (this.authorRepository.count() == 0) {
      List<String> authors = Files.readAllLines(Path.of("src/main/resources/static/authors"));

      for (String name : authors) {
        this.authorRepository.save(new Author(name));
      }
    }
  }

  @Override
  public Author findByName(String fullName) {
    return this.authorRepository.findByFullName(fullName).get();
  }

}



