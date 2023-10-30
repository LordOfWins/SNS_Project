package init.helloworld;

import init.init.Console;
import init.init.PackMan;
import init.init.Runner;
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

