package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.entity.Author;
import com.example.books_rest_api.model.entity.Book;
import com.example.books_rest_api.repository.BookRepository;
import com.example.books_rest_api.service.AuthorService;
import com.example.books_rest_api.service.BookService;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
  private final AuthorService authorService;
  private final BookRepository bookRepository;

  public BookServiceImpl(AuthorService authorService, BookRepository bookRepository) {
    this.authorService = authorService;
    this.bookRepository = bookRepository;
  }

  @Override
  public void initBooks() throws IOException {
    if (this.bookRepository.count() == 0) {
      Files.readAllLines(Path.of("src/main/resources/static/books"))
              .forEach(l -> {
                String[] tokens = l.split(" - ");
                String bookTitle = tokens[1];

                int year = Integer.parseInt(tokens[2]);
                LocalDate date = LocalDate.of(year, 1, 1);

                Author author = getAuthorByNames(tokens[0]);
                Integer copies = Integer.parseInt(tokens[3]);
                String publisher = tokens[4];

                Book book = new Book(bookTitle, date, copies, author, publisher);
                this.bookRepository.save(book);
              });
    }
  }

  private Author getAuthorByNames(String token) {
    String firstName = token.split(" ")[0];
    String lastName = token.split(" ")[1];

    return this.authorService.findAuthorByFirstAndLastNames(firstName, lastName);
  }
}

