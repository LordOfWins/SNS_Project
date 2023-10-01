package com.spring.init;

import java.util.logging.Level;

import static com.spring.init.GamingBasic.*;

public class PackMan implements Console {

    //up function
    public void up() {
        LOG.log(Level.INFO, FONT_WHITE + "North direction" + RESET);
    }

    //down function
    public void down() {
        LOG.log(Level.INFO, FONT_WHITE + "South direction" + RESET);
    }

    //left function
    public void left() {
        LOG.log(Level.INFO, FONT_WHITE + "West direction" + RESET);
    }

    //right function
    public void right() {
        LOG.log(Level.INFO, FONT_WHITE + "East direction" + RESET);
    }
}
