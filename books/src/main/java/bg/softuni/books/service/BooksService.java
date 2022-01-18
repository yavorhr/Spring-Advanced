package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.BookEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

public interface BooksService {
  List<BookDTO> getAllBooks();

  Optional<BookDTO> getBookById(long id);

  Page<BookDTO> getBooks(
      int pageNo,
      int pageSize,
      String sortBy);

  void deleteBook(long id);

  long createBook(BookDTO bookDTO);

  Long updateBook(BookDTO bookDTO);
}
