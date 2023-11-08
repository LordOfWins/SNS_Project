package com.springstudy.webapp.todo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

// <관리하고자 하는 Bean, Id의 타입>
public interface TodoRepository extends JpaRepository<Todo, Integer> {
  List<Todo> findByUsername(String username);
}
