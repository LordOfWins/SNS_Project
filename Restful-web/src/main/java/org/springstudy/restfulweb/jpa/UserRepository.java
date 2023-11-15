package org.springstudy.restfulweb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springstudy.restfulweb.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {}