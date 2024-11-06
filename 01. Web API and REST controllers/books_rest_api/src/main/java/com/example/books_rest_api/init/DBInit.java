package com.example.books_rest_api.init;

import com.example.books_rest_api.service.AuthorService;
import com.example.books_rest_api.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
  private final AuthorService authorService;
  private final BookService bookService;

  public DBInit(AuthorService authorService, BookService bookService) {
    this.authorService = authorService;
    this.bookService = bookService;
  }

  @Override
  public void run(String... args) throws Exception {
    this.authorService.initAuthors();
    this.bookService.initBooks();
  }
}
