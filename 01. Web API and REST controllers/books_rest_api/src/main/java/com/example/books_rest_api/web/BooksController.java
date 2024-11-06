package com.example.books_rest_api.web;

import com.example.books_rest_api.model.dto.BookDto;
import com.example.books_rest_api.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks(){

    List<BookDto> allBooks = bookService.findAllBooks();

    return ResponseEntity.ok(allBooks);
  }
}
