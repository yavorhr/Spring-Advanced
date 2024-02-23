package bg.softuni.lazy.model.crossjoin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "posts")
@Entity
public class PostEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
  private String post;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name="post_id")
  private List<CommentEntity> comments = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name="post_id")
  private List<TagEntity> tags = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public PostEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getPost() {
    return post;
  }

  public PostEntity setPost(String post) {
    this.post = post;
    return this;
  }

  public List<CommentEntity> getComments() {
    return comments;
  }

  public PostEntity setComments(
      List<CommentEntity> comments) {
    this.comments = comments;
    return this;
  }

  public List<TagEntity> getTags() {
    return tags;
  }

  public PostEntity setTags(List<TagEntity> tags) {
    this.tags = tags;
    return this;
  }
}
