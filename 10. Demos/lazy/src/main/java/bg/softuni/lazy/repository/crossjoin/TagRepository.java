package bg.softuni.lazy.repository.crossjoin;

import bg.softuni.lazy.model.crossjoin.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

}
