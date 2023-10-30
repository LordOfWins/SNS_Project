package springframework.example0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("springframework.example0")
public class SimpleDependencyInjection {
    private static final Log LOG = LogFactory.getLog(SimpleDependencyInjection.class);

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(SimpleDependencyInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(LOG::info);

            LOG.info(context.getBean(YourBusinessClass.class));
        }
    }

}
 