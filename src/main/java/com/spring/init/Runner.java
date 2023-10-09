package com.spring.init;

import java.util.logging.Level;

import static com.spring.init.GamingBasic.*;


public class Runner {

    Console console;

    public Runner(Console console) {
        this.console = console;
    }

    public void run() {
        LOG.log(Level.INFO, FONT_WHITE + "Running game: {0}" + RESET, FONT_BRIGHT_CYAN + console + RESET);
        console.up();
        console.down();
        console.left();
        console.right();
    }
}
