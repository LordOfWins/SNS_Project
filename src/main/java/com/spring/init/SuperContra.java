package com.spring.init;

import java.util.logging.Level;

import static com.spring.init.GamingBasic.*;

public class SuperContra {
    //up function
    public void up() {
        LOG.log(Level.INFO, FONT_WHITE + "Going up" + RESET);
    }

    //down function
    public void down() {
        LOG.log(Level.INFO, FONT_WHITE + "Going down" + RESET);
    }

    //left function
    public void left() {
        LOG.log(Level.INFO, FONT_WHITE + "Going left" + RESET);
    }

    //right function
    public void right() {
        LOG.log(Level.INFO, FONT_WHITE + "Going right" + RESET);
    }

}
