package org.spring.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static org.spring.init.GamingBasic.*;

@Component
@Qualifier("Runner")
public class Runner {

    private static final Log LOG = LogFactory.getLog(Runner.class);

    private final Console console;

    public Runner(@Qualifier("SuperContra") Console console) {
        this.console = console;
    }

    public void run() {
        LOG.info(FONT_WHITE + "Running game: " + FONT_BRIGHT_CYAN + console + RESET);
        console.up();
        console.down();
        console.left();
        console.right();
    }
}
