package init.init;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static init.init.GamingBasic.FONT_WHITE;
import static init.init.GamingBasic.RESET;

public class SuperContra implements Console {

    private static final Log LOG = LogFactory.getLog(SuperContra.class);

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
        LOG.info(FONT_WHITE + "Going left" + RESET);
    }

    //right function
    public void right() {
        LOG.info(FONT_WHITE + "Going right" + RESET);
    }

}
