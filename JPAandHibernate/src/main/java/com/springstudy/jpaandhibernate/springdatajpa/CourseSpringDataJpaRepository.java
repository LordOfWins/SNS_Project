package com.springstudy.jpaandhibernate.springdatajpa;

import com.springstudy.jpaandhibernate.course.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
  List<Course> findByAuthor(String author);

  List<Course> findByName(String name);
}
