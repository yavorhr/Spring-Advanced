package bg.softuni.booksclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AuthorDTO {

  private String name;

  public String getName() {
    return name;
  }

  public AuthorDTO setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "AuthorDTO{" +
        "name='" + name + '\'' +
        '}';
  }
}
