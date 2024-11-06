package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.dto.AuthorDto;
import com.example.books_rest_api.model.dto.BookDto;
import com.example.books_rest_api.model.entity.Author;
import com.example.books_rest_api.model.entity.Book;
import com.example.books_rest_api.repository.BookRepository;
import com.example.books_rest_api.service.AuthorService;
import com.example.books_rest_api.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
  private final AuthorService authorService;
  private final BookRepository bookRepository;
  private final ModelMapper modelMapper;

  public BookServiceImpl(AuthorService authorService, BookRepository bookRepository, ModelMapper modelMapper) {
    this.authorService = authorService;
    this.bookRepository = bookRepository;
    this.modelMapper = modelMapper;
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

  @Override
  public List<BookDto> findAllBooks() {
    return this.bookRepository
            .findAll()
            .stream()
            .map(b -> {
              BookDto bookDto = this.modelMapper.map(b, BookDto.class);
              AuthorDto authorDto = this.modelMapper.map(b.getAuthor(), AuthorDto.class);
              bookDto.setAuthor(authorDto);

              return bookDto;
            })
            .collect(Collectors.toList());
  }

  @Override
  public Optional<BookDto> findById(Long id) {
    return this.bookRepository.findById(id).map(b -> this.modelMapper.map(b, BookDto.class));
  }

  private Author getAuthorByNames(String token) {
    String firstName = token.split(" ")[0];
    String lastName = token.split(" ")[1];

    return this.authorService.findAuthorByFirstAndLastNames(firstName, lastName);
  }
}

