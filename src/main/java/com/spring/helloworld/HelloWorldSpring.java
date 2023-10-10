package com.spring.helloworld;

import com.spring.spring.Address;
import com.spring.spring.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class HelloWorldSpring {

    public static final Log log = LogFactory.getLog(HelloWorldSpring.class);

    public static void main(String[] args) {
        //Launch a Spring context

        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguation.class)) {
            //Configure the things that we want Spring to manage
            log.info("name : " + context.getBean("name"));

            log.info("age : " + context.getBean("age"));

            log.info("person : " + context.getBean("person"));

            log.info("personMethodCall : " + context.getBean("personMethodCall"));

            log.info("personParameter : " + context.getBean("personParameter"));

            log.info("personParameter2 : " + context.getBean("personParameter2"));

            log.info("address2 : " + context.getBean("address2"));

            log.info("Person.class : " + context.getBean(Person.class));

            log.info("Address.class : " + context.getBean(Address.class));

            log.info("personParameter3 : " + context.getBean("personParameter3"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(log::info);
        }
    }
}