package com.example.books_rest_api.service;

import com.example.books_rest_api.model.dto.BookDto;

import java.io.IOException;
import java.util.List;

public interface BookService {
  void initBooks() throws IOException;

  List<BookDto> findAllBooks();
}
