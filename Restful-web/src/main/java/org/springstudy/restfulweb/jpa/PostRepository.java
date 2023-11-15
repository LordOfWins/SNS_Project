package org.springstudy.restfulweb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springstudy.restfulweb.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {}