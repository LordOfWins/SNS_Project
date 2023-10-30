package com.springstudy.jpaandhibernate.course.jdbc;

import com.springstudy.jpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

  private static final String insertQuery =
      """
                insert into course (id, name, author)
                values (?,?,?);
            """;

  private static final String deleteQuery =
      """
                delete from course
                where id = ?;
            """;

  private static final String selectQuery =
      """
                select * from course
                where id = ?;
            """;
  @Autowired private JdbcTemplate springJdbcTemplate;

  public void insert(Course course) {
    springJdbcTemplate.update(insertQuery, course.getId(), course.getName(), course.getAuthor());
  }

  public void deleteById(long id) {
    springJdbcTemplate.update(deleteQuery, id);
  }

  public Course findById(long id) {
    return springJdbcTemplate.queryForObject(
        selectQuery, new BeanPropertyRowMapper<>(Course.class), id);
  }
}
