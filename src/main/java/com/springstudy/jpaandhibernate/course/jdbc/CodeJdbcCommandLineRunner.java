package com.springstudy.jpaandhibernate.course.jdbc;

import com.springstudy.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CodeJdbcCommandLineRunner implements CommandLineRunner {
  @Autowired private CourseJdbcRepository repository;

  @Override
  public void run(String... args) {
    repository.insert(new Course(1, "33", "test"));
    repository.insert(new Course(2, "44", "test"));
    repository.insert(new Course(3, "55", "test"));
    repository.deleteById(1);
    System.out.println(repository.findById(2));
    System.out.println(repository.findById(3));
  }
}
