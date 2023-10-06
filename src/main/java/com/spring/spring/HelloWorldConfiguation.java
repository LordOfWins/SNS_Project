package com.spring.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguation {

    @Bean
    public String name() {
        return "World";
    }

    @Bean
    public int age() {
        return 30;
    }

    @Bean
    public Person person() {
        return new Person("Seungjae", 27, new Address("I", "Seoul"));
    }

    @Bean
    public Person personMethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person personParameter(String name, int age, Address address2) {
        return new Person(name, age, address2);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("I", "Seoul");
    }

    @Bean(name = "address3")
    public Address address3() {
        return new Address("K", "Busan");
    }

    public record Person(String name, int age, Address address) {
    }


    public record Address(String street, String city) {
    }
}
