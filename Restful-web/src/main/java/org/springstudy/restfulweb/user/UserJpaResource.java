package org.springstudy.restfulweb.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springstudy.restfulweb.jpa.PostRepository;
import org.springstudy.restfulweb.jpa.UserRepository;

@RestController
public class UserJpaResource {
  private final UserRepository userRepository;

  private final PostRepository postRepository;

  public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @GetMapping("/jpa/users")
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> findUser(@PathVariable Integer id) {

    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id:" + id);
    }
    EntityModel<User> entityModel = EntityModel.of(user.get());

    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());

    entityModel.add(link.withRel("all-users"));
    return entityModel;
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    userRepository.deleteById(id);
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> getAllPost(@PathVariable Integer id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id:" + id);
    }
    return user.get().getPosts();
  }

  @PostMapping("/jpa/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("id:" + id);
    }
    post.setUser(user.get());
    Post savedPost = postRepository.save(post);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedPost.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @GetMapping("/jpa/users/{id}/posts/{postId}")
  public EntityModel<Post> getPost(@PathVariable int id, @PathVariable int postId) {

    Optional<Post> post = postRepository.findById(postId);
    if (post.isEmpty()) {
      throw new PostNotFoundException("id:" + postId);
    }
    EntityModel<Post> entityModel = EntityModel.of(post.get());
    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllPost(id));
    entityModel.add(link.withRel("all-posts"));
    return entityModel;
  }
}