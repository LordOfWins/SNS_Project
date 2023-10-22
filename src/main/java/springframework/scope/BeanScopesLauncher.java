package springframework.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.spring.scope")
public class BeanScopesLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncher.class)) {
            System.out.println(context.getBean(Normal.class));
            System.out.println(context.getBean(Normal.class));

            System.out.println(context.getBean(Prototype.class));
            System.out.println(context.getBean(Prototype.class));
            System.out.println(context.getBean(Prototype.class));
        }
    }
}
