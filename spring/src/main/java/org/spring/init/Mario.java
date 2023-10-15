package org.spring.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static org.spring.init.GamingBasic.FONT_WHITE;
import static org.spring.init.GamingBasic.RESET;

@Component
@Primary
public class Mario implements Console {

    private static final Log LOG = LogFactory.getLog(Mario.class);

    //up function
    public void up() {
        LOG.info(FONT_WHITE + "Going up" + RESET);
    }

    //down function
    public void down() {
        LOG.info(FONT_WHITE + "Going down" + RESET);
    }

    //left function
    public void left() {
        LOG.info("Going left" + RESET);
    }

    //right function
    public void right() {
        LOG.info(FONT_WHITE + "Going right" + RESET);
    }
}
