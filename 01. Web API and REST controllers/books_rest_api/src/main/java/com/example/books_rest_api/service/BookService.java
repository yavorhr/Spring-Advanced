package com.example.books_rest_api.service;

import com.example.books_rest_api.model.dto.BookDto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BookService {
  void initBooks() throws IOException;

  List<BookDto> findAllBooks();

  Optional<BookDto> findById(Long id);
}
