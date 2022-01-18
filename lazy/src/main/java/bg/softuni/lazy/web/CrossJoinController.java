package bg.softuni.lazy.web;

import bg.softuni.lazy.model.crossjoin.CommentEntity;
import bg.softuni.lazy.model.crossjoin.PostEntity;
import bg.softuni.lazy.model.crossjoin.TagEntity;
//import bg.softuni.lazy.repository.crossjoin.PostRepository;
import bg.softuni.lazy.repository.crossjoin.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrossJoinController {

  private final PostRepository postRepository;

  public CrossJoinController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping("/test-cross")
  public String testCross() {

    PostEntity post = postRepository.findById(1L).get();

    System.out.println("---------1");


      System.out.println("----------");
        System.out.println (post.getPost());
        System.out.println (post.getTags().stream().map(TagEntity::getName).collect(Collectors.joining(", ")));
        System.out.println (post.getComments().stream().map(CommentEntity::getName).collect(Collectors.joining(", ")));
      System.out.println("----------");

    return "Hello!";
  }
}
