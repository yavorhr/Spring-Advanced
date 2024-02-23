package bg.softuni.books.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity extends BaseEntity {

  private String title;
  private String isbn;

  @ManyToOne
  private AuthorEntity author;

  public String getTitle() {
    return title;
  }

  public BookEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getIsbn() {
    return isbn;
  }

  public BookEntity setIsbn(String isbn) {
    this.isbn = isbn;
    return this;
  }

  public AuthorEntity getAuthor() {
    return author;
  }

  public BookEntity setAuthor(AuthorEntity author) {
    this.author = author;
    return this;
  }

  @Override
  public String toString() {
    return "BookEntity{" +
        "title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", author=" + author +
        '}';
  }
}
