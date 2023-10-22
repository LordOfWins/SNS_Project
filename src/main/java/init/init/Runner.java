package init.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static init.init.GamingBasic.*;


public class Runner {

    private static final Log LOG = LogFactory.getLog(Runner.class);

    private final Console console;

    public Runner(Console console) {
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
