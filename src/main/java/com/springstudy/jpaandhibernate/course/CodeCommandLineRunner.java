package com.springstudy.jpaandhibernate.course;

import com.springstudy.jpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CodeCommandLineRunner implements CommandLineRunner {
  //  @Autowired private CourseJdbcRepository repository;
  @Autowired private CourseJpaRepository repository;

  @Override
  public void run(String... args) {
    repository.insert(new Course(1, "33 JPA", "test"));
    repository.insert(new Course(2, "44 JPA", "test"));
    repository.insert(new Course(3, "55 JPA", "test"));
    repository.deleteById(1);
    System.out.println(repository.findById(2));
    System.out.println(repository.findById(3));
  }
}
