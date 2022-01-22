package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MobileleUserServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public MobileleUserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    // The purpose of this method is to map our user representation (UserEntity)
    // to the user representation in the spring sercurity world (UserDetails).
    // The only thing that spring will provide to us is the user name.
    // The user name will come from the HTML login form.

    UserEntity userEntity =
        userRepository.findByUsername(username).
            orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));

    return mapToUserDetails(userEntity);
  }

  private static UserDetails mapToUserDetails(UserEntity userEntity) {

    // GrantedAuthority is the representation of a user role in the
    // spring world. SimpleGrantedAuthority is an implementation of GrantedAuthority
    // which spring provides for our convenience.
    // Our representation of role is UserRoleEntity
    List<GrantedAuthority> auhtorities =
        userEntity.
            getRoles().
            stream().
            map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name())).
            collect(Collectors.toList());

    // User is the spring implementation of UserDetails interface.
    return new MobileleUser(
        userEntity.getUsername(),
        userEntity.getPassword(),
        auhtorities
    );
  }
}
