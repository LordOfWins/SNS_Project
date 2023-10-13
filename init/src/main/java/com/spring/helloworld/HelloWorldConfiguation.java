package com.spring.helloworld;

import com.spring.spring.Address;
import com.spring.spring.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloWorldConfiguation {

    public static final int AGE = 27;

    @Bean
    public String name() {
        return "Seungjae";
    }

    @Bean
    public int myAge() {
        return AGE;
    }

    @Bean
    public Person person() {
        return new Person("Seungjae", AGE, new Address("ggg", "Seoul"));
    }

    @Bean
    public Person personMethodCall() {
        return new Person(name(), age(), address3());
    }

    @Bean
    public Person personParameter(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    @Primary
    public Person personParameter2(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person personParameter3(
            @Qualifier("name") String name, @Qualifier("age") int age, @Qualifier("address3") Address address3) {
        return new Person(name, age, address3);
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("RTERTE", "Seoul");
    }

    @Bean(name = "address3")
    @Qualifier("address3")
    public Address address3() {
        return new Address("GHGGH", "Busan");
    }

}


