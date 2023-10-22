package springframework.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan
public class DependencyInjection {
    private static final Log LOG = LogFactory.getLog(DependencyInjection.class);

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(LOG::info);
        }
    }

}
 