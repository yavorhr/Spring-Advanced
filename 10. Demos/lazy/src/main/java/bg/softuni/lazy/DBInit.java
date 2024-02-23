package bg.softuni.lazy;

import bg.softuni.lazy.model.crossjoin.CommentEntity;
import bg.softuni.lazy.model.crossjoin.PostEntity;
import bg.softuni.lazy.model.crossjoin.TagEntity;
import bg.softuni.lazy.model.nplus1.RoleEntity;
import bg.softuni.lazy.model.nplus1.UserEntity;
import bg.softuni.lazy.repository.crossjoin.CommentRepository;
import bg.softuni.lazy.repository.crossjoin.PostRepository;
import bg.softuni.lazy.repository.crossjoin.TagRepository;
import bg.softuni.lazy.repository.nplus1.RoleRepository;
import bg.softuni.lazy.repository.nplus1.UserRepository;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

  private final RoleRepository roleRepository;
  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentRepository commentRepository;
  private final TagRepository tagRepository;

  public DBInit(RoleRepository roleRepository,
      UserRepository userRepository,
      PostRepository postRepository,
      CommentRepository commentRepository,
      TagRepository tagRepository
  ) {
    this.roleRepository = roleRepository;
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.commentRepository = commentRepository;
    this.tagRepository = tagRepository;
  }

  @Transactional
  @Override
  public void run(String... args) throws Exception {

    initUsers();
    initPosts();

  }

  private void initUsers() {

    if (userRepository.count() == 0) {
      RoleEntity adminRole = new RoleEntity().setName("ADMIN");
      RoleEntity userRole = new RoleEntity().setName("USER");

      adminRole = roleRepository.save(adminRole);
      userRole = roleRepository.save(userRole);

      UserEntity user1 = new UserEntity().setName("Lucho");
      user1.setRoles(List.of(
          adminRole,
          userRole
      ));

      UserEntity user2 = new UserEntity().setName("Pesho");
      user2.setRoles(List.of(
          adminRole
      ));

      userRepository.saveAll(List.of(user1, user2));
    }
  }

  private void initPosts() {
    if (postRepository.count() == 0) {
      PostEntity post = new PostEntity().setPost("A post");

      CommentEntity comment1 = commentRepository.save(new CommentEntity().setName("Abe eeeeeei"));
      CommentEntity comment2 = commentRepository.save(new CommentEntity().setName("Vodesthiq!"));

      TagEntity tag1 = tagRepository.save(new TagEntity().setName("tag1"));
      TagEntity tag2 = tagRepository.save(new TagEntity().setName("tag2"));

      post.setComments(List.of(comment1, comment2));
      post.setTags(List.of(tag1, tag2));

      postRepository.save(post);
    }
  }

}
