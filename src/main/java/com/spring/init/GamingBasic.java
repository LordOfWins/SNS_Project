package com.spring.init;

import java.util.logging.Logger;

public class GamingBasic {
    // [전역 변수 선언 부분]
    public static final String RESET = "\u001B[0m";

    //bright white
    public static final String FONT_WHITE = "\u001B[97m";

    //bright cyan
    public static final String FONT_BRIGHT_CYAN = "\u001B[96m";

    public static final Logger LOG = Logger.getGlobal();

    public static void main(String[] args) {
//        var game=new Mario();
        var game = new SuperContra();
        var runner = new Runner(game);
        runner.run();
    }
}
