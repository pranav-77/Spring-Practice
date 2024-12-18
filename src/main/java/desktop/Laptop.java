package desktop;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Laptop implements Computer {
    @Override
    public void work() {
        System.out.println("Working with laptop");
    }
}
