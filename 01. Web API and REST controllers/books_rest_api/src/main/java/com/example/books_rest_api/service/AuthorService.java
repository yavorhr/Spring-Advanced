package com.example.books_rest_api.service;

import com.example.books_rest_api.model.entity.Author;

import java.io.IOException;
import java.util.Optional;

public interface AuthorService {
  void initAuthors() throws IOException;

  Optional<Author> findByName(String fullName);

  Author saveAuthor(Author newAuthor);
}
