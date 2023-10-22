package init.helloworld;

import init.spring.Address;
import init.spring.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class HelloWorldSpring {

    private static final Log LOG = LogFactory.getLog(HelloWorldSpring.class);

    public static void main(String[] args) {
        //Launch a Spring context

        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguation.class)) {
            //Configure the things that we want Spring to manage
            LOG.info("name : " + context.getBean("name"));

            LOG.info("age : " + context.getBean("myAge"));

            LOG.info("person : " + context.getBean("person"));

            LOG.info("personMethodCall : " + context.getBean("personMethodCall"));

            LOG.info("personParameter : " + context.getBean("personParameter"));

            LOG.info("personParameter2 : " + context.getBean("personParameter2"));

            LOG.info("address2 : " + context.getBean("address2"));

            LOG.info("Person.class : " + context.getBean(Person.class));

            LOG.info("Address.class : " + context.getBean(Address.class));

            LOG.info("personParameter3 : " + context.getBean("personParameter3"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(LOG::info);
        }
    }
}