package bg.softuni.errors.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found!")
public class ObjectNotFoundException extends RuntimeException{

  private final Long objectId;

  public ObjectNotFoundException(Long objectId) {
    super("Object with id " + objectId + " not found!");
    this.objectId = objectId;
  }

  public Long getObjectId() {
    return objectId;
  }
}
