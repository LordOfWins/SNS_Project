package com.spring.spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HelloWorldSpring {

    public static final Log log = LogFactory.getLog(HelloWorldSpring.class);

    public static void main(String[] args) {
        //Launch a Spring context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguation.class);
        //Configure the things that we want Spring to manage
        log.info(context.getBean("name"));

        log.info(context.getBean("age"));

        log.info(context.getBean("person"));

        log.info(context.getBean("personMethodCall"));

        log.info(context.getBean("personParameter"));

        log.info(context.getBean("address2"));

//        log.info(context.getBean(HelloWorldConfiguation.Address.class));
    }
}
