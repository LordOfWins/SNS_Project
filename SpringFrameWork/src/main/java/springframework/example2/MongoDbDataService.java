package springframework.example2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {

    public static final int ELEVEN = 11;
    public static final int TWENTY_TWO = 22;
    public static final int THIRTY_THREE = 33;
    public static final int FORTY_FOUR = 44;
    public static final int FIFTY_FIVE = 55;

    @Override
    public int[] getData() {
        return new int[]{ELEVEN, TWENTY_TWO, THIRTY_THREE, FORTY_FOUR, FIFTY_FIVE};
    }
}
