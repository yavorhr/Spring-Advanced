package bg.softuni.lazy.web;

import bg.softuni.lazy.model.nplus1.RoleEntity;
import bg.softuni.lazy.model.nplus1.UserEntity;
import bg.softuni.lazy.repository.nplus1.RoleRepository;
import bg.softuni.lazy.repository.nplus1.UserRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NPlus1Controller {

  private final RoleRepository roleRepository;
  private final UserRepository userRepository;

  public NPlus1Controller(RoleRepository roleRepository,
      UserRepository userRepository) {
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
  }


  @Transactional
  @GetMapping("/nplus1")
  public String getNPlus1() {

    System.out.println("---------------------------------");
    System.out.println("GET ALL USERS ENTITY GRAPH");
    List<UserEntity> allUsers = userRepository.getAllUsersByEntityGraph();
    System.out.println("GET ALL USERS: [" + allUsers.size() + "]");

    for (UserEntity user : allUsers) {
      System.out.println("---------------------------------");
      System.out.println("USER:" + user.getName());
      System.out.println("ROLES: " + user.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
    }

    return "hello";
  }

}
