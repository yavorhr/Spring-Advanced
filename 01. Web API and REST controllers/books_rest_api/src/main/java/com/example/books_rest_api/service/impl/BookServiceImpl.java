package com.example.books_rest_api.service.impl;

import com.example.books_rest_api.model.dto.AddBookDto;
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
  public List<BookDto> findAllBooks() {
    return this.bookRepository
            .findAll()
            .stream()
            .map(b -> {
              BookDto bookDto = mapToBookDto(b);
              AuthorDto authorDto = this.modelMapper.map(b.getAuthor(), AuthorDto.class);
              bookDto.setAuthor(authorDto);

              return bookDto;
            })
            .collect(Collectors.toList());
  }

  @Override
  public Optional<BookDto> findById(Long id) {
    return this.bookRepository
            .findById(id)
            .map(this::mapToBookDto);
  }

  @Override
  public void deleteBook(Long id) {
    this.bookRepository.deleteById(id);
  }

  @Override
  public BookDto createBook(AddBookDto addBookDto) {
    Book book = this.modelMapper.map(addBookDto, Book.class);

    Optional<Author> author = this.authorService.findByName(addBookDto.getAuthor());

    if (author.isEmpty()) {
      var newAuthor = new Author(addBookDto.getAuthor());
      newAuthor = this.authorService.saveAuthor(newAuthor);
      book.setAuthor(newAuthor);
    } else {
      book.setAuthor(author.get());
    }

    book = this.bookRepository.save(book);

    return this.modelMapper.map(book, BookDto.class);
  }

  @Override
  public void initBooks() throws IOException {
    if (this.bookRepository.count() == 0) {
      Files.readAllLines(Path.of("src/main/resources/static/books"))
              .forEach(l -> {
                Book book = getBook(l);
                this.bookRepository.save(book);
              });
    }
  }

  // Helpers
  private Book getBook(String l) {
    String[] tokens = l.split(" - ");
    String bookTitle = tokens[1];

    int year = Integer.parseInt(tokens[2]);
    LocalDate date = LocalDate.of(year, 1, 1);

    Author author = getAuthorByName(tokens[0]).get();
    Integer copies = Integer.parseInt(tokens[3]);
    String publisher = tokens[4];

    return new Book(bookTitle, date, copies, author, publisher);
  }

  private BookDto mapToBookDto(Book b) {
    return this.modelMapper.map(b, BookDto.class);
  }

  private Optional<Author> getAuthorByName(String name) {
    return this.authorService.findByName(name);
  }
}

