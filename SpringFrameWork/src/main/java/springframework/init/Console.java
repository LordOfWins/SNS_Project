package springframework.init;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Console")
public interface Console {
    void up();

    void down();

    void left();

    void right();
}
