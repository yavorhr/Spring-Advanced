package bg.softuni.hateoas.model.entity;


import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private BigDecimal price;
  private boolean enabled;

  public Long getId() {
    return id;
  }

  public CourseEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public CourseEntity setName(String name) {
    this.name = name;
    return this;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public CourseEntity setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public CourseEntity setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }
}
