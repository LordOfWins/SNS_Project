package org.spring.example2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("org.spring.example2")
public class RealWorldDependencyInjection {
    private static final Log LOG = LogFactory.getLog(RealWorldDependencyInjection.class);

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(RealWorldDependencyInjection.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(LOG::info);

            LOG.info(context.getBean(BusinessCalculationService.class).findMax());
        }
    }

}
 