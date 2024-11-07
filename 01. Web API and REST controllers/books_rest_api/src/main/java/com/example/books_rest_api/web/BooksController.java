package com.example.books_rest_api.web;

import com.example.books_rest_api.model.dto.AddBookDto;
import com.example.books_rest_api.model.dto.BookDto;
import com.example.books_rest_api.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
  private final BookService bookService;

  public BooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public ResponseEntity<List<BookDto>> getAllBooks() {

    List<BookDto> allBooks = bookService.findAllBooks();

    return ResponseEntity.ok(allBooks);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {

    Optional<BookDto> book = this.bookService.findById(id);

    if (book.isEmpty()) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(book.get());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BookDto> deleteBook(@PathVariable Long id) {
    this.bookService.deleteBook(id);

    return ResponseEntity
            .noContent()
            .build();
  }

  @PostMapping()
  public ResponseEntity<BookDto> createBook(
          @RequestBody AddBookDto addBookDto) {

    BookDto bookDto =
            this.bookService.createBook(addBookDto);

    URI location = URI.create("/books/" + bookDto.getId());

    return ResponseEntity
            .created(location) // Sets HTTP status 201
            .body(bookDto); // Includes the created resource in the response body
  }
}
