package desktop;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Override
    public void work() {
        System.out.println("Working with Desktop");
    }
}
