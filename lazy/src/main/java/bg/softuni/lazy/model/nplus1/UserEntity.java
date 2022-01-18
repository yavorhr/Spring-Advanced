package bg.softuni.lazy.model.nplus1;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@NamedEntityGraph(
    name="user-roles",
    attributeNodes = {
        @NamedAttributeNode("roles")
    }
)
@Entity
@Table(name = "user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<RoleEntity> roles;

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

  public List<RoleEntity> getRoles() {
    return roles;
  }

  public UserEntity setRoles(List<RoleEntity> roles) {
    this.roles = roles;
    return this;
  }
}
