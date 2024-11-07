package com.example.books_rest_api.service;

import com.example.books_rest_api.model.entity.Author;

import java.io.IOException;

public interface AuthorService {
  void initAuthors() throws IOException;

  Author findByName(String fullName);
}
