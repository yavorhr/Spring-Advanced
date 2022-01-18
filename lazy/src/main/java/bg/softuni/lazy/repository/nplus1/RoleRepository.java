package bg.softuni.lazy.repository.nplus1;

import bg.softuni.lazy.model.nplus1.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
