package bg.softuni.lazy.repository.nplus1;

import bg.softuni.lazy.model.nplus1.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query("SELECT u FROM UserEntity u LEFT JOIN FETCH u.roles")
  List<UserEntity> getAllUsersByFetch();

  @EntityGraph(value = "user-roles")
  @Query("SELECT u FROM UserEntity u")
  List<UserEntity> getAllUsersByEntityGraph();

}
