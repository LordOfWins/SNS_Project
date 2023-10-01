package com.spring.init;

import java.util.logging.Level;

import static com.spring.init.GamingBasic.*;


public class Runner {

    Console game;

    public Runner(Console game) {
        this.game = game;
    }

    public void run() {
        LOG.log(Level.INFO, FONT_WHITE + "Running game: {0}" + RESET, FONT_BRIGHT_CYAN + game + RESET);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
