package com.spring.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguation {

    @Bean
    public String test() {
        return "World";
    }
}
