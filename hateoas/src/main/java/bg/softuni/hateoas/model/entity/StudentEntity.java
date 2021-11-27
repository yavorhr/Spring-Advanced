package bg.softuni.hateoas.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int age;
  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
  private List<OrderEntity> orders = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public StudentEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentEntity setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public StudentEntity setAge(int age) {
    this.age = age;
    return this;
  }

  public List<OrderEntity> getOrders() {
    return orders;
  }

  public StudentEntity setOrders(List<OrderEntity> orders) {
    this.orders = orders;
    return this;
  }
}
