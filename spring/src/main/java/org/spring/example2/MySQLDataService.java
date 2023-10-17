package org.spring.example2;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;

    @Override
    public int[] getData() {

        return new int[]{ONE, TWO, THREE, FOUR, FIVE};
    }
}
