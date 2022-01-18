package bg.softuni.lazy.repository.crossjoin;

import bg.softuni.lazy.model.crossjoin.CommentEntity;
import bg.softuni.lazy.model.crossjoin.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<PostEntity, Long> {

}
