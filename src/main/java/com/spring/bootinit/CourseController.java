package com.spring.bootinit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "seungjae"),
                new Course(2, "Learn DevOps", "seungjae"),
                new Course(3, "Learn Python", "seungjae"));
    }
}
