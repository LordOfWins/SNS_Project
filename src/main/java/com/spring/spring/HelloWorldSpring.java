package com.spring.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpring {
    public static void main(String[] args) {
        //Launch a Spring context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguation.class);
        //Configure the things that we want Spring to manage
        System.out.println(context.getBean("test"));
    }
}
