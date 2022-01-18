package bg.softuni.cloudinary.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String url;
  private String publicId;

  public Long getId() {
    return id;
  }

  public PictureEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public PictureEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public PictureEntity setUrl(String url) {
    this.url = url;
    return this;
  }

  public String getPublicId() {
    return publicId;
  }

  public PictureEntity setPublicId(String publicId) {
    this.publicId = publicId;
    return this;
  }
}
