package springframework.lazy_init;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springframework.lazy_init")
public class LazyInitLauncer {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitLauncer.class)) {
            var log = LogFactory.getLog(LazyInitLauncer.class);
            log.info(context.getBean(ClassB.class).classA);
        }
    }
}