package com.spring.helloworld;

import com.spring.init.Console;
import com.spring.init.PackMan;
import com.spring.init.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguation {
    @Bean
    public Console console() {
        return new PackMan();
    }

    @Bean
    public Runner runner(Console console) {
        return new Runner(console);
    }

}

