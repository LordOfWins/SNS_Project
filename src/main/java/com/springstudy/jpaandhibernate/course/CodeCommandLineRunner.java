package com.springstudy.jpaandhibernate.course;

import com.springstudy.jpaandhibernate.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CodeCommandLineRunner implements CommandLineRunner {
  //  @Autowired private CourseJdbcRepository repository;
  //  @Autowired private CourseJpaRepository repository;

  @Autowired private CourseSpringDataJpaRepository repository;

  @Override
  public void run(String... args) {
    repository.save(new Course(1, "33 JPA", "test"));
    repository.save(new Course(2, "44 JPA", "test"));
    repository.save(new Course(3, "55 JPA", "test"));
    repository.deleteById(1L);
    System.out.println(repository.findById(2L));
    System.out.println(repository.findById(3L));

    System.out.println(repository.findAll());
    System.out.println(repository.count());

    System.out.println(repository.findByAuthor("test"));

    System.out.println(repository.findByName("55 JPA"));
    System.out.println(repository.findByName("44 JPA"));
  }
}
