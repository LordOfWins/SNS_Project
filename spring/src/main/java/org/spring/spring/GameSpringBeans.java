package org.spring.spring;

import org.spring.init.Console;
import org.spring.init.Runner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("org.spring.init")
public class GameSpringBeans {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GameSpringBeans.class);
        context.getBean(Console.class).up();
        context.getBean(Runner.class).run();
    }

}
 