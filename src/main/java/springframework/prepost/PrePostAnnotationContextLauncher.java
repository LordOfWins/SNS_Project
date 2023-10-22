package springframework.prepost;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependencies are injected");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void destroy() {
        System.out.println("clean up");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic is done");
    }
}

@Configuration
@ComponentScan("org.spring.prepost")
public class PrePostAnnotationContextLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
