package bg.softuni.hateoas.model.dto;

public class StudentDTO {

  private Long id;
  private String name;
  private int age;

  public Long getId() {
    return id;
  }

  public StudentDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentDTO setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public StudentDTO setAge(int age) {
    this.age = age;
    return this;
  }
}
