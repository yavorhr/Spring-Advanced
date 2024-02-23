package bg.softuni.demo.cascade;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// User 1 -> Address 1
//        -> Address 2
//        -> Address 3

@Entity
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  private UserEntity user;

  private String street;

  public Long getId() {
    return id;
  }

  public AddressEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public AddressEntity setStreet(String street) {
    this.street = street;
    return this;
  }

  public UserEntity getUser() {
    return user;
  }

  public AddressEntity setUser(UserEntity user) {
    this.user = user;
    return this;
  }
}
