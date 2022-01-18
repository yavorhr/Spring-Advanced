package bg.softuni.booksclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BookDTO {

  private AuthorDTO author;

  private Long id;
  private String title;
  private String isbn;

  public AuthorDTO getAuthor() {
    return author;
  }

  public BookDTO setAuthor(AuthorDTO author) {
    this.author = author;
    return this;
  }

  public Long getId() {
    return id;
  }

  public BookDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public BookDTO setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public BookDTO setIsbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  @Override
  public String toString() {
    return "BookDTO{" +
        "author=" + author +
        ", id=" + id +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        '}';
  }
}
