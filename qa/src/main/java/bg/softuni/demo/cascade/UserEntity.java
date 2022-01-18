package bg.softuni.demo.cascade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<AddressEntity> addresses = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public UserEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public UserEntity setName(String name) {
    this.name = name;
    return this;
  }

  public List<AddressEntity> getAddresses() {
    return addresses;
  }

  public UserEntity setAddresses(List<AddressEntity> addresses) {
    this.addresses = addresses;
    return this;
  }
}
